package org.avp.client.gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;
import org.avp.AliensVsPredator;
import org.avp.packets.server.PacketAddTurretPlayerTarget;
import org.avp.packets.server.PacketAddTurretTarget;
import org.avp.packets.server.PacketReadFromDataDevice;
import org.avp.packets.server.PacketRemoveTurretPlayerTarget;
import org.avp.packets.server.PacketRemoveTurretTarget;
import org.avp.packets.server.PacketWriteToDataDevice;
import org.avp.tile.TileEntityTurret;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import com.asx.mdx.lib.client.gui.GuiCustomButton;
import com.asx.mdx.lib.client.gui.GuiCustomTextbox;
import com.asx.mdx.lib.client.gui.IAction;
import com.asx.mdx.lib.client.gui.IGuiElement;
import com.asx.mdx.lib.client.util.Draw;
import com.asx.mdx.lib.util.Game;
import com.asx.mdx.lib.world.entity.Entities;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiTurret extends GuiContainer
{
    private static ArrayList<Pair<EntityEntry, String>> entityList;
	
	private static final Comparator<Pair<EntityEntry, String>> ALPHABETICAL_COMPARATOR = Comparator.comparing((entry) -> entry.getRight());
	
    private TileEntityTurret                   tile;
    private static GuiCustomButton             buttonScrollUp = new GuiCustomButton(0, 0, 0, 20, 20, "\u21e7");
    private static GuiCustomButton             buttonScrollDown = new GuiCustomButton(1, 0, 0, 20, 20, "\u21e9");
    private static GuiCustomButton             buttonAddAsTarget = new GuiCustomButton(2, 0, 0, 50, 20, "");
    private static GuiCustomButton             buttonSave = new GuiCustomButton(3, 0, 0, 35, 20, "S");
    private static GuiCustomButton             buttonLoad = new GuiCustomButton(4, 0, 0, 35, 20, "L");
    private static GuiCustomTextbox            playerNameInput = new GuiCustomTextbox(0, 0, 200, 20);
    private static int                         scroll        = 0;
    
    private static IAction scrollDownAction = new IAction() {
        @Override
        public void perform(IGuiElement element)
        {
            scrollDown();
        }
    };
    
    private static IAction scrollUpAction = new IAction() {
        @Override
        public void perform(IGuiElement element)
        {
            scrollUp();
        }
    };
    
    private IAction saveAction = new IAction() {
        @Override
        public void perform(IGuiElement element)
        {
            AliensVsPredator.network().sendToServer(new PacketWriteToDataDevice(tile.getPos().getX(), tile.getPos().getY(), tile.getPos().getZ(), 0));
            tile.writeToOtherDevice(0);
        }
    };
    
    private IAction loadAction = new IAction() {
        @Override
        public void perform(IGuiElement element)
        {
            tile.getTargetHelper().getDangerousTargets().clear();
            AliensVsPredator.network().sendToServer(new PacketReadFromDataDevice(tile.getPos().getX(), tile.getPos().getY(), tile.getPos().getZ(), 0));
            tile.readFromOtherDevice(0);
        }
    };
    
    private IAction addAsTargetAction = new IAction() {
        @Override
        public void perform(IGuiElement element)
        {
            if (tile != null)
            {
                if (playerNameInput != null && playerNameInput.getText().isEmpty() || playerNameInput == null)
                {
                    if (!tile.getTargetHelper().canTargetType(getCurrentSelectedEntity().getEntityClass()))
                    {
                        tile.getTargetHelper().addTargetType(getCurrentSelectedEntity().getEntityClass());
                        
                        AliensVsPredator.network().sendToServer(new PacketAddTurretTarget(tile.getPos().getX(), tile.getPos().getY(), tile.getPos().getZ(), Entities.getEntityRegistrationId(getCurrentSelectedEntity().getEntityClass())));
                    }
                    else
                    {
                        tile.getTargetHelper().removeTargetType(getCurrentSelectedEntity().getEntityClass());
                        AliensVsPredator.network().sendToServer(new PacketRemoveTurretTarget(tile.getPos().getX(), tile.getPos().getY(), tile.getPos().getZ(), Entities.getEntityRegistrationId(getCurrentSelectedEntity().getEntityClass())));
                    }
                }
                else
                {
                    if (!tile.getTargetHelper().getTargetPlayers().contains(playerNameInput.getText()))
                    {
                        Game.minecraft().player.sendChatMessage("'" + playerNameInput.getText() + "' added to turret player target list.");
                        tile.getTargetHelper().addTargetPlayer(playerNameInput.getText());
                        AliensVsPredator.network().sendToServer(new PacketAddTurretPlayerTarget(tile.getPos().getX(), tile.getPos().getY(), tile.getPos().getZ(), playerNameInput.getText()));
                    }
                    else
                    {
                        Game.minecraft().player.sendChatMessage("'" + playerNameInput.getText() + "' removed from turret player target list.");
                        tile.getTargetHelper().removeTargetPlayer(playerNameInput.getText());
                        AliensVsPredator.network().sendToServer(new PacketRemoveTurretPlayerTarget(tile.getPos().getX(), tile.getPos().getY(), tile.getPos().getZ(), playerNameInput.getText()));
                    }
                }
            }
        }
    };
    
    static {

        playerNameInput.setFocused(true);
        playerNameInput.setWidth(225);
        playerNameInput.setHeight(16);
        playerNameInput.setBackgroundColor(0xFF000000);
        playerNameInput.setTextColor(0xFF99FF55);
        playerNameInput.setBorderColor(0xFF555555);
        
        buttonScrollUp.setAction(scrollUpAction);
        
        buttonScrollDown.setAction(scrollDownAction);
        
        buttonAddAsTarget.width = 20;
        
        buttonSave.width = 14;
        
        buttonLoad.width = 14;
    }
    

    public GuiTurret(EntityPlayer player, TileEntityTurret turret, World world, int x, int y, int z)
    {
        super(turret.getContainer(player));
        this.xSize = 225;
        this.ySize = 200;
        this.tile = turret;
        
        if (entityList == null) {
            entityList = new ArrayList<Pair<EntityEntry, String>>();
            
            for (EntityEntry entry: ForgeRegistries.ENTITIES.getValuesCollection()) {
            	Entity instance = entry.newInstance(world);
            	if (instance instanceof EntityLiving) {
            		entityList.add(Pair.of(entry, instance.getName()));
            	}
            }
            
            entityList.sort(ALPHABETICAL_COMPARATOR);
        }
    }

    @Override
    public void initGui()
    {
        super.initGui();
        
        scroll = 0;
        playerNameInput.setText("");
        
        playerNameInput.setX(guiLeft);
        playerNameInput.setY(guiTop + ySize - 34);

        buttonScrollUp.x = this.guiLeft + xSize + 5;
        buttonScrollUp.y = this.guiTop + 42;

        buttonScrollDown.x = this.guiLeft + this.xSize + 5;
        buttonScrollDown.y = this.guiTop + 88;

        buttonAddAsTarget.x = (this.guiLeft + this.xSize + 5);
        buttonAddAsTarget.y = this.guiTop + 65;
        buttonAddAsTarget.setAction(addAsTargetAction);

        buttonSave.x = (this.guiLeft + this.xSize - 38);
        buttonSave.y = (this.guiTop + 19);
        buttonSave.setAction(saveAction);

        buttonLoad.x = (this.guiLeft + this.xSize - 21);
        buttonLoad.y = (this.guiTop + 19);
        
        buttonLoad.setAction(loadAction);
    }

    @Override
    public void onGuiClosed()
    {
        super.onGuiClosed();

        tile.applyUpgrades();

    	Collection<String> entityIdentifiers = tile.getTargetHelper().getDangerousTargets().stream().map((e) -> Entities.getEntityRegistrationId(e)).collect(Collectors.toList());
        AliensVsPredator.network().sendToServer(new PacketAddTurretTarget(this.tile.getPos().getX(), this.tile.getPos().getY(), this.tile.getPos().getZ(), entityIdentifiers));
    }

    @Override
    @SideOnly(Side.CLIENT)
    protected void drawGuiContainerBackgroundLayer(float f, int mouseX, int mouseY)
    {
        AliensVsPredator.resources().GUI_TURRET.bind();
        drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);

        int stacksTotal = this.tile.getContainer(this.mc.player).getAmmoBay().getSizeInventory() * this.tile.getContainer(this.mc.player).getAmmoBay().getInventoryStackLimit();
        int stacksCurrent = 0;

        for (int i = 0; i < this.tile.getContainer(this.mc.player).getAmmoBay().getSizeInventory(); i++)
        {
            ItemStack stack = this.tile.getContainer(this.mc.player).getAmmoBay().getStackInSlot(i);

            if ((stack == null) || (stack.getItem() != this.tile.getAmmoHelper().getItemAmmo()))
                continue;
            stacksCurrent += stack.getCount();
        }

        Draw.drawProgressBar("Magazine " + (this.tile.getAmmoHelper().getCurAmmo() <= 0 ? 0 : this.tile.getAmmoHelper().getCurAmmo()) + "/" + this.tile.getAmmoHelper().getMaxAmmo(), this.tile.getAmmoHelper().getMaxAmmo(), this.tile.getAmmoHelper().getCurAmmo() < 0 ? 1 : this.tile.getAmmoHelper().getCurAmmo(), this.guiLeft + 7, this.guiTop + 20, this.xSize - 100, 3, 1, this.tile.getAmmoHelper().getCurAmmo() < this.tile.getAmmoHelper().getMaxAmmo() / 2 ? -22016 : this.tile.getAmmoHelper().getCurAmmo() < this.tile.getAmmoHelper().getMaxAmmo() / 6 ? -65536 : -16733441, false);
        Draw.drawProgressBar("Total " + stacksCurrent + "/" + stacksTotal, stacksTotal, stacksCurrent, this.guiLeft + 7, this.guiTop + 30, this.xSize - 100, 3, 1, stacksCurrent < stacksTotal / 2 ? -22016 : stacksCurrent < stacksTotal / 6 ? -65536 : -16733441, false);
    }

    @Override
    public void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        for (int x = 0; x < entityList.size(); x++)
        {
            int yPos = 56;
            int yEntryPos = yPos + 11 * x;

            Pair<EntityEntry, String> entityData = x + scroll < entityList.size() ? entityList.get(x + scroll) : null;
            
            if (entityData == null) {
            	continue;
            }
            
            EntityEntry entity = entityData.getLeft();
            String entityName = entityData.getRight();

            if (yEntryPos <= yPos + 50) {
            	Class<? extends Entity> entityClass = entity.getEntityClass();
                Draw.drawRectWithOutline(3, yEntryPos - 4, 134, 12, 1, 0x00000000, 0xFF444444);
                Draw.drawString(entityName, 6, yEntryPos - 2, this.tile.getTargetHelper().canTargetType(entityClass) ? (getCurrentSelectedEntity() == entity ? 0xFFFF8800 : 0xFFFF0000) : (getCurrentSelectedEntity() == entity ? 0xFFFFFFFF : 0xFF444444), false);
            }
        }

        super.drawGuiContainerForegroundLayer(mouseX, mouseY);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float p_73863_3_)
    {
        super.drawScreen(mouseX, mouseY, p_73863_3_);

        // Update
        
        if (!this.tile.getTargetHelper().canTargetType(getCurrentSelectedEntity().getEntityClass()))
        {
            buttonAddAsTarget.displayString = "+";
            buttonAddAsTarget.overlayColorHover = 0xFF00FF77;
        }
        else
        {
            buttonAddAsTarget.displayString = "-";
            buttonAddAsTarget.overlayColorHover = 0xFFFF0033;
        }
        
        // Draw

        playerNameInput.drawTextBox();

        buttonScrollUp.baseColor = scroll == 0 ? 0x22000000 : 0xAA000000;
        buttonScrollUp.drawButton();
        
        buttonScrollDown.baseColor = scroll >= entityList.size() - 1 ? 0x22000000 : 0xAA000000;
        buttonScrollDown.drawButton();
        
        buttonAddAsTarget.drawButton();
        buttonSave.drawButton();
        buttonLoad.drawButton();
    }

    @Override
    public void updateScreen()
    {
        super.updateScreen();

        int dWheel = Mouse.getDWheel();

        if (dWheel > 0)
        {
            scrollUp();
        }
        else if (dWheel < 0)
        {
            scrollDown();
        }

        if (Keyboard.isKeyDown(Keyboard.KEY_DOWN))
        {
            scrollDown();
        }

        if (Keyboard.isKeyDown(Keyboard.KEY_UP))
        {
            scrollUp();
        }
    }

    public EntityEntry getCurrentSelectedEntity()
    {
        return entityList.get(scroll).getLeft();
    }

    public static void scrollUp()
    {
        if (scroll > 0)
        {
            scroll -= 1;
        }
    }

    public static void scrollDown()
    {
        if (scroll < entityList.size() - 1)
        {
            scroll += 1;
        }
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException
    {
        if (playerNameInput.isEnabled() && playerNameInput.isFocused() && keyCode != Keyboard.KEY_ESCAPE)
        {
            if (keyCode == Keyboard.KEY_RETURN)
            {
                String commandLineText = playerNameInput.getText();

                if (commandLineText.startsWith("/"))
                {
                    String command = commandLineText.substring(1, commandLineText.length());
                    String[] args = command.split(" ");

                    if (args.length > 0 && !args[0].equalsIgnoreCase(""))
                    {
                        if (args[0].equalsIgnoreCase("lasercolor"))
                        {
                            if (args.length == 2)
                            {
                                try
                                {
                                    if (args[1].contains("0x"))
                                    {
                                        args[1] = args[1].replace("0x", "");
                                    }

                                    int color = (int) Long.parseLong(args[1], 16);
                                    String hexString = "0x" + Integer.toHexString(color).toUpperCase();
                                    this.tile.beamColor = color;
                                    mc.player.getCommandSenderEntity().sendMessage(new TextComponentString("Set turret laser beam color to " + hexString));
                                }
                                catch (Exception e)
                                {
                                    mc.player.getCommandSenderEntity().sendMessage(new TextComponentString("Invalid hexadecimal color string '" + args[1] + "'"));
                                }
                            }
                            else
                            {
                                mc.player.getCommandSenderEntity().sendMessage(new TextComponentString("Invalid amount of arguments provided."));
                            }
                        }
                        else if (args[0].equalsIgnoreCase("test"))
                        {
                            mc.player.getCommandSenderEntity().sendMessage(new TextComponentString("0 argument command executed."));
                        }
                        else if (args[0].equalsIgnoreCase("help"))
                        {
                            mc.player.getCommandSenderEntity().sendMessage(new TextComponentString("lasercolor <hex> - Set the laser beam color"));
                            mc.player.getCommandSenderEntity().sendMessage(new TextComponentString("help - Shows this command list."));
                        }
                        else
                        {
                            mc.player.getCommandSenderEntity().sendMessage(new TextComponentString(String.format("Command '%s' not recognized. See '/help'.", args[0])));
                        }
                    }
                    else
                    {
                        mc.player.getCommandSenderEntity().sendMessage(new TextComponentString("No command provided."));
                    }

                    playerNameInput.setText("");
                    return;
                }
                else
                {
                    buttonAddAsTarget.getAction().perform(buttonAddAsTarget);
                    return;
                }
            }

            playerNameInput.textboxKeyTyped(typedChar, keyCode);
            return;
        }

        super.keyTyped(typedChar, keyCode);
    }
}
