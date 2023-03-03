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
	
	private static final Comparator<Pair<EntityEntry, String>> ALPHABETICAL_COMPARATOR = new Comparator<Pair<EntityEntry, String>>() {
		@Override
		public int compare(Pair<EntityEntry, String> o1, Pair<EntityEntry, String> o2) {
			return o1.getRight().compareTo(o2.getRight());
		}
    };
	
    private TileEntityTurret                   tile;
    private GuiCustomButton                    buttonScrollUp;
    private GuiCustomButton                    buttonScrollDown;
    private GuiCustomButton                    buttonAddAsTarget;
    private GuiCustomButton                    buttonSave;
    private GuiCustomButton                    buttonLoad;
    private GuiCustomTextbox                   playerNameInput;
    private int                                scroll        = 0;
    

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

        this.buttonScrollUp = new GuiCustomButton(0, 0, 0, 20, 20, "");
        this.buttonScrollDown = new GuiCustomButton(1, 0, 0, 20, 20, "");
        this.buttonAddAsTarget = new GuiCustomButton(2, 0, 0, 50, 20, "");
        this.buttonSave = new GuiCustomButton(3, 0, 0, 35, 20, "");
        this.buttonLoad = new GuiCustomButton(4, 0, 0, 35, 20, "");

        this.playerNameInput = new GuiCustomTextbox(0, 0, 200, 20);
        this.playerNameInput.setFocused(true);
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

            Pair<EntityEntry, String> entityData = x + this.scroll < entityList.size() ? entityList.get(x + this.scroll) : null;
            
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

        this.playerNameInput.setX(guiLeft);
        this.playerNameInput.setY(guiTop + ySize - 34);
        this.playerNameInput.setWidth(225);
        this.playerNameInput.setHeight(16);
        this.playerNameInput.setBackgroundColor(0xFF000000);
        this.playerNameInput.setTextColor(0xFF99FF55);
        this.playerNameInput.setBorderColor(0xFF555555);
        this.playerNameInput.drawTextBox();

        this.buttonScrollUp.x = this.guiLeft + xSize + 5;
        this.buttonScrollUp.y = this.guiTop + 42;
        this.buttonScrollUp.displayString = "\u21e7";
        this.buttonScrollUp.baseColor = this.getScroll() == 0 ? 0x22000000 : 0xAA000000;
        this.buttonScrollUp.drawButton();
        this.buttonScrollUp.setAction(new IAction() {
            @Override
            public void perform(IGuiElement element)
            {
                scrollDown();
            }
        });

        this.buttonScrollDown.x = this.guiLeft + this.xSize + 5;
        this.buttonScrollDown.y = this.guiTop + 88;
        this.buttonScrollDown.displayString = "\u21e9";
        this.buttonScrollDown.baseColor = this.getScroll() >= entityList.size() - 1 ? 0x22000000 : 0xAA000000;
        this.buttonScrollDown.drawButton();
        this.buttonScrollDown.setAction(new IAction() {
            @Override
            public void perform(IGuiElement element)
            {
                scrollUp();
            }
        });

        this.buttonAddAsTarget.x = (this.guiLeft + this.xSize + 5);
        this.buttonAddAsTarget.y = this.guiTop + 65;
        this.buttonAddAsTarget.width = 20;
        this.buttonAddAsTarget.drawButton();
        this.buttonAddAsTarget.setAction(new IAction() {
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
        });

        this.buttonSave.x = (this.guiLeft + this.xSize - 38);
        this.buttonSave.y = (this.guiTop + 19);
        this.buttonSave.displayString = "S";
        this.buttonSave.width = 14;
        this.buttonSave.drawButton();
        this.buttonSave.setAction(new IAction() {
            @Override
            public void perform(IGuiElement element)
            {
                AliensVsPredator.network().sendToServer(new PacketWriteToDataDevice(tile.getPos().getX(), tile.getPos().getY(), tile.getPos().getZ(), 0));
                tile.writeToOtherDevice(0);
            }
        });

        this.buttonLoad.x = (this.guiLeft + this.xSize - 21);
        this.buttonLoad.y = (this.guiTop + 19);
        this.buttonLoad.displayString = "L";
        this.buttonLoad.width = 14;
        this.buttonLoad.drawButton();
        this.buttonLoad.setAction(new IAction() {
            @Override
            public void perform(IGuiElement element)
            {
                tile.getTargetHelper().getDangerousTargets().clear();
                AliensVsPredator.network().sendToServer(new PacketReadFromDataDevice(tile.getPos().getX(), tile.getPos().getY(), tile.getPos().getZ(), 0));
                tile.readFromOtherDevice(0);
            }
        });

        if (!this.tile.getTargetHelper().canTargetType(getCurrentSelectedEntity().getEntityClass()))
        {
            this.buttonAddAsTarget.displayString = "+";
            this.buttonAddAsTarget.overlayColorHover = 0xFF00FF77;
        }
        else
        {
            this.buttonAddAsTarget.displayString = "-";
            this.buttonAddAsTarget.overlayColorHover = 0xFFFF0033;
        }
    }

    @Override
    public void updateScreen()
    {
        super.updateScreen();

        int dWheel = Mouse.getDWheel();

        if (dWheel > 0)
        {
            scrollDown();
        }
        else if (dWheel < 0)
        {
            scrollUp();
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
        return entityList.get(getScroll()).getLeft();
    }

    public void scrollDown()
    {
        if (this.scroll > 0)
        {
            this.scroll -= 1;
        }
    }

    public void scrollUp()
    {
        if (this.scroll < entityList.size() - 1)
        {
            this.scroll += 1;
        }
    }

    public int getScroll()
    {
        return this.scroll;
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException
    {
        if (this.playerNameInput.isEnabled() && this.playerNameInput.isFocused() && keyCode != Keyboard.KEY_ESCAPE)
        {
            if (keyCode == Keyboard.KEY_RETURN)
            {
                String commandLineText = this.playerNameInput.getText();

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

                    this.playerNameInput.setText("");
                    return;
                }
                else
                {
                    this.buttonAddAsTarget.getAction().perform(this.buttonAddAsTarget);
                    return;
                }
            }

            this.playerNameInput.textboxKeyTyped(typedChar, keyCode);
            return;
        }

        super.keyTyped(typedChar, keyCode);
    }
}
