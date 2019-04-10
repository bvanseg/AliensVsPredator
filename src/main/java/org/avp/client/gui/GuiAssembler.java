package org.avp.client.gui;

import java.io.IOException;
import java.util.ArrayList;

import org.avp.AliensVsPredator;
import org.avp.item.crafting.AssemblyManager;
import org.avp.item.crafting.Schematic;
import org.avp.packets.server.PacketAssemble;
import org.avp.tile.TileEntityAssembler;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import com.asx.mdx.lib.client.gui.GuiCustomButton;
import com.asx.mdx.lib.client.gui.GuiCustomTextbox;
import com.asx.mdx.lib.client.gui.IAction;
import com.asx.mdx.lib.client.gui.IGuiElement;
import com.asx.mdx.lib.client.util.Draw;
import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.util.Game;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GuiAssembler extends GuiContainer
{
    private ArrayList<Schematic> schematics;
    private GuiCustomButton      buttonScrollUp;
    private GuiCustomButton      buttonScrollDown;
    private GuiCustomButton      buttonAssemble;
    private GuiCustomButton      buttonAssemble4;
    private GuiCustomButton      buttonAssemble8;
    private GuiCustomButton      buttonAssemble16;
    private GuiCustomButton      buttonAssemble32;
    private GuiCustomButton      buttonAssembleStack;

    private GuiCustomTextbox     searchBar;

    private int                  scroll       = 0;
    private boolean              hasMaterials = false;

    public GuiAssembler(InventoryPlayer invPlayer, TileEntityAssembler assembler, World world, int x, int y, int z)
    {
        super(assembler.getNewContainer(invPlayer.player));
        this.schematics = new ArrayList<Schematic>(AssemblyManager.instance.schematics());
        this.xSize = 256;
        this.ySize = 170;
        this.allowUserInput = true;
    }

    @Override
    public void initGui()
    {
        super.initGui();
        this.buttonScrollUp = new GuiCustomButton(0, 0, 0, 20, 20, "");
        this.buttonScrollDown = new GuiCustomButton(1, 0, 0, 20, 20, "");
        this.buttonAssemble = new GuiCustomButton(2, 0, 0, 50, 20, "");
        this.buttonAssemble4 = new GuiCustomButton(2, 0, 0, 50, 20, "");
        this.buttonAssemble8 = new GuiCustomButton(2, 0, 0, 50, 20, "");
        this.buttonAssemble16 = new GuiCustomButton(2, 0, 0, 50, 20, "");
        this.buttonAssemble32 = new GuiCustomButton(2, 0, 0, 50, 20, "");
        this.buttonAssembleStack = new GuiCustomButton(2, 0, 0, 50, 20, "");
        this.searchBar = new GuiCustomTextbox(0, 0, 100, 20);
        this.searchBar.setFocused(true);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        if (schematics != null && schematics.size() > 0)
        {
            Schematic selectedSchematic = schematics.size() > 0 ? schematics.get(getScroll()) : null;

            if (selectedSchematic != null)
            {
                int curStack = -1;
                int progress = 0;
                int maxProgress = 0;
                int assemblerSidePanelWidth = this.xSize - (this.xSize / 2);
                int assemblerSidePanelX = -assemblerSidePanelWidth;

                for (ItemStack stack : selectedSchematic.getItemsRequired())
                {
                    curStack++;
                    int amountOfStack = AssemblyManager.amountForMatchingStack(Game.minecraft().player, stack);
                    int stackY = 15 + (curStack * 8);
                    int curStackSize = (amountOfStack > stack.getCount() ? stack.getCount() : amountOfStack);
                    OpenGL.enableBlend();
                    Draw.drawRect(assemblerSidePanelX, stackY - 2, assemblerSidePanelWidth, 8, 0xDD000000);

                    OpenGL.pushMatrix();
                    {
                        float s = 0.5F;
                        float m = 1F / s;
                        int textColor = curStackSize >= stack.getCount() ? 0xFF00AAFF : curStackSize < stack.getCount() && curStackSize > 0 ? 0xFFFFAA00 : 0xFF888888;

                        OpenGL.scale(s, s, 1.0F);
                        Draw.drawString(curStackSize + "/" + stack.getCount(), Math.round((-12) * m), Math.round((stackY) * m), textColor, false);
                        Draw.drawString(stack.getDisplayName(), Math.round((assemblerSidePanelX + 12) * m), Math.round((stackY) * m), 0xFF888888, false);
                        Draw.drawItem(stack, Math.round((assemblerSidePanelX + 2) * m), Math.round((stackY - 2) * m), 16, 16);
                    }
                    OpenGL.popMatrix();

                    maxProgress += stack.getCount();

                    if (amountOfStack > 0)
                    {
                        progress += amountOfStack > stack.getCount() ? stack.getCount() : amountOfStack;
                    }
                }

                int percentComplete = (progress * 100 / maxProgress);
                String progressBarString = "" + progress + "/" + maxProgress + " Materials";
                int progressBarColor = percentComplete < 25 ? 0xFFFF2222 : percentComplete < 50 ? 0xFFFFAA00 : (percentComplete == 100 ? 0xFF00AAFF : 0xFFFFAA00);
                Draw.drawProgressBar(progressBarString, maxProgress, progress, assemblerSidePanelX, 0, assemblerSidePanelWidth, 8, 3, progressBarColor, false);

                if (percentComplete == 100)
                {
                    this.hasMaterials = true;
                }
                else
                {
                    this.hasMaterials = false;
                }
            }

            /**
             * Draw the schematics in the assembler
             */

            int curItem = -1;

            for (Schematic schematic : schematics)
            {
                if (schematic != null && schematic.getItemStackAssembled() != null)
                {
                    Item item = schematic.getItemStackAssembled().getItem();

                    if (item != null && schematic.getItemStackAssembled().getDisplayName().toLowerCase().contains(this.searchBar.getText().toLowerCase()))
                    {
                        curItem++;
                        int numberRendered = curItem - (getScroll());
                        int entryHeight = 10;
                        int entryWidth = this.xSize - Math.round(this.xSize / 5.35F);
                        int entryX = 4;
                        int entryY = 33 + (numberRendered) * entryHeight;

                        if (numberRendered >= 0 && numberRendered <= 10)
                        {
                            OpenGL.enableBlend();
                            OpenGL.disableBlend();
                            Draw.drawRect(entryX, entryY + entryHeight, entryWidth, 1, 0xFF000000);
                            Draw.drawString(I18n.translateToLocal(item.getTranslationKey() + ".name"), entryX + 13, entryY + 2, curItem == this.scroll ? 0xFF00AAFF : 0xFF555555, false);
                            Draw.drawItem(schematic.getItemStackAssembled(), entryX + 2, entryY + 2, 8, 8);
                        }
                    }
                }
            }
        }

        super.drawGuiContainerForegroundLayer(mouseX, mouseY);
    }

    @SideOnly(Side.CLIENT)
    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int x, int y)
    {
        AliensVsPredator.resources().GUI_ASSEMBLER.bind();
        drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException
    {
        super.actionPerformed(button);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float renderPartial)
    {
        super.drawScreen(mouseX, mouseY, renderPartial);

        int buttonWidth = 38;
        int buttonOffsetX = buttonWidth + 9;
        int offset = 0;

        this.searchBar.setX(this.guiLeft + 4);
        this.searchBar.setY(this.guiTop + 17);
        this.searchBar.setWidth(208);
        this.searchBar.setHeight(15);
        this.searchBar.setBackgroundColor(0xFF000000);
        this.searchBar.setTextColor(0xFF88FF00);
        this.searchBar.drawTextBox();

        this.buttonScrollUp.x = this.guiLeft + xSize + 5 - buttonOffsetX;
        this.buttonScrollUp.y = this.guiTop + 4;
        this.buttonScrollUp.width = buttonWidth;
        this.buttonScrollUp.height = 19;
        this.buttonScrollUp.displayString = "\u21e7";
        this.buttonScrollUp.baseColor = this.getScroll() == 0 ? 0x22000000 : 0xAA000000;
        this.buttonScrollUp.overlayColorHover = 0x22FFFFFF;
        this.buttonScrollUp.drawButton();
        this.buttonScrollUp.setAction(new IAction() {
            @Override
            public void perform(IGuiElement element)
            {
                scrollDown();
            }
        });

        boolean hasMaterials1X = AssemblyManager.tryAssembly(Game.minecraft().player, schematics.size() > 0 ? schematics.size() > 0 ? schematics.get(getScroll()) : null : null, 1, true) >= 1;
        this.buttonAssemble.x = (this.guiLeft + this.xSize + 5) - buttonOffsetX;
        this.buttonAssemble.y = this.guiTop + 3 + (offset += 20);
        this.buttonAssemble.displayString = "\u2692 x1";
        this.buttonAssemble.width = buttonWidth;
        this.buttonAssemble.baseColor = hasMaterials1X ? 0xAA000000 : 0x22000000;
        this.buttonAssemble.overlayColorHover = hasMaterials1X ? 0xFF88FF00 : 0xFFFF0000;
        this.buttonAssemble.fontColor = this.buttonAssemble.isMouseOver() ? 0xFF000000 : 0xFFFFFFFF;
        this.buttonAssemble.fontShadow = false;
        this.buttonAssemble.drawButton();
        this.buttonAssemble.setAction(new IAction() {
            @Override
            public void perform(IGuiElement element)
            {
                Schematic selectedSchematic = schematics.size() > 0 ? schematics.get(getScroll()) : null;

                if (selectedSchematic != null)
                {
                    AssemblyManager.handleAssembly(selectedSchematic, Game.minecraft().player);
                    AliensVsPredator.network().sendToServer(new PacketAssemble(selectedSchematic.getName(), 1));
                }
            }
        });

        // System.out.println(AssemblyManager.tryAssembly(Game.minecraft().player, schematics.size() > 0 ? schematics.get(getScroll()) : null, 4, true));
        boolean hasMaterials4X = AssemblyManager.tryAssembly(Game.minecraft().player, schematics.size() > 0 ? schematics.get(getScroll()) : null, 4, true) >= 4;
        this.buttonAssemble4.x = (this.guiLeft + this.xSize + 5) - buttonOffsetX;
        this.buttonAssemble4.y = this.guiTop + 3 + (offset += 20);
        this.buttonAssemble4.displayString = "\u2692 x4";
        this.buttonAssemble4.width = buttonWidth;
        this.buttonAssemble4.baseColor = hasMaterials4X ? 0xAA000000 : 0x22000000;
        this.buttonAssemble4.overlayColorHover = hasMaterials4X ? 0xFF88FF00 : 0xFFFF0000;
        this.buttonAssemble4.fontColor = this.buttonAssemble4.isMouseOver() ? 0xFF000000 : 0xFFFFFFFF;
        this.buttonAssemble4.fontShadow = false;
        this.buttonAssemble4.drawButton();
        this.buttonAssemble4.setAction(new IAction() {
            @Override
            public void perform(IGuiElement element)
            {
                Schematic selectedSchematic = schematics.size() > 0 ? schematics.get(getScroll()) : null;

                if (selectedSchematic != null)
                {
                    AssemblyManager.handleAssembly(selectedSchematic, Game.minecraft().player);
                    AliensVsPredator.network().sendToServer(new PacketAssemble(selectedSchematic.getName(), 4));
                }
            }
        });

        boolean hasMaterials8X = AssemblyManager.tryAssembly(Game.minecraft().player, schematics.size() > 0 ? schematics.get(getScroll()) : null, 8, true) >= 8;
        this.buttonAssemble8.x = (this.guiLeft + this.xSize + 5) - buttonOffsetX;
        this.buttonAssemble8.y = this.guiTop + 3 + (offset += 20);
        this.buttonAssemble8.displayString = "\u2692 x8";
        this.buttonAssemble8.width = buttonWidth;
        this.buttonAssemble8.baseColor = hasMaterials8X ? 0xAA000000 : 0x22000000;
        this.buttonAssemble8.overlayColorHover = hasMaterials8X ? 0xFF88FF00 : 0xFFFF0000;
        this.buttonAssemble8.fontColor = this.buttonAssemble8.isMouseOver() ? 0xFF000000 : 0xFFFFFFFF;
        this.buttonAssemble8.fontShadow = false;
        this.buttonAssemble8.drawButton();
        this.buttonAssemble8.setAction(new IAction() {
            @Override
            public void perform(IGuiElement element)
            {
                Schematic selectedSchematic = schematics.size() > 0 ? schematics.get(getScroll()) : null;

                if (selectedSchematic != null)
                {
                    AssemblyManager.handleAssembly(selectedSchematic, Game.minecraft().player);
                    AliensVsPredator.network().sendToServer(new PacketAssemble(selectedSchematic.getName(), 8));
                }
            }
        });

        boolean hasMaterials16X = AssemblyManager.tryAssembly(Game.minecraft().player, schematics.size() > 0 ? schematics.get(getScroll()) : null, 16, true) >= 16;
        this.buttonAssemble16.x = (this.guiLeft + this.xSize + 5) - buttonOffsetX;
        this.buttonAssemble16.y = this.guiTop + 3 + (offset += 20);
        this.buttonAssemble16.displayString = "\u2692 x16";
        this.buttonAssemble16.width = buttonWidth;
        this.buttonAssemble16.baseColor = hasMaterials16X ? 0xAA000000 : 0x22000000;
        this.buttonAssemble16.overlayColorHover = hasMaterials16X ? 0xFF88FF00 : 0xFFFF0000;
        this.buttonAssemble16.fontColor = this.buttonAssemble16.isMouseOver() ? 0xFF000000 : 0xFFFFFFFF;
        this.buttonAssemble16.fontShadow = false;
        this.buttonAssemble16.drawButton();
        this.buttonAssemble16.setAction(new IAction() {
            @Override
            public void perform(IGuiElement element)
            {
                Schematic selectedSchematic = schematics.size() > 0 ? schematics.get(getScroll()) : null;

                if (selectedSchematic != null)
                {
                    AssemblyManager.handleAssembly(selectedSchematic, Game.minecraft().player);
                    AliensVsPredator.network().sendToServer(new PacketAssemble(selectedSchematic.getName(), 16));
                }
            }
        });

        boolean hasMaterial32X = AssemblyManager.tryAssembly(Game.minecraft().player, schematics.size() > 0 ? schematics.get(getScroll()) : null, 32, true) >= 32;
        this.buttonAssemble32.x = (this.guiLeft + this.xSize + 5) - buttonOffsetX;
        this.buttonAssemble32.y = this.guiTop + 3 + (offset += 20);
        this.buttonAssemble32.displayString = "\u2692 x32";
        this.buttonAssemble32.width = buttonWidth;
        this.buttonAssemble32.baseColor = hasMaterial32X ? 0xAA000000 : 0x22000000;
        this.buttonAssemble32.overlayColorHover = hasMaterial32X ? 0xFF88FF00 : 0xFFFF0000;
        this.buttonAssemble32.fontColor = this.buttonAssemble32.isMouseOver() ? 0xFF000000 : 0xFFFFFFFF;
        this.buttonAssemble32.fontShadow = false;
        this.buttonAssemble32.drawButton();
        this.buttonAssemble32.setAction(new IAction() {
            @Override
            public void perform(IGuiElement element)
            {
                Schematic selectedSchematic = schematics.size() > 0 ? schematics.get(getScroll()) : null;

                if (selectedSchematic != null)
                {
                    AssemblyManager.handleAssembly(selectedSchematic, Game.minecraft().player);
                    AliensVsPredator.network().sendToServer(new PacketAssemble(selectedSchematic.getName(), 32));
                }
            }
        });

        boolean hasMaterialStack = AssemblyManager.tryAssembly(Game.minecraft().player, schematics.size() > 0 ? schematics.get(getScroll()) : null, 64, true) >= 64;
        this.buttonAssembleStack.x = (this.guiLeft + this.xSize + 5) - buttonOffsetX;
        this.buttonAssembleStack.y = this.guiTop + 3 + (offset += 20);
        this.buttonAssembleStack.displayString = "\u2692 x64";
        this.buttonAssembleStack.width = buttonWidth;
        this.buttonAssembleStack.baseColor = hasMaterialStack ? 0xAA000000 : 0x22000000;
        this.buttonAssembleStack.overlayColorHover = hasMaterialStack ? 0xFF88FF00 : 0xFFFF0000;
        this.buttonAssembleStack.fontColor = this.buttonAssembleStack.isMouseOver() ? 0xFF000000 : 0xFFFFFFFF;
        this.buttonAssembleStack.fontShadow = false;
        this.buttonAssembleStack.drawButton();
        this.buttonAssembleStack.setAction(new IAction() {
            @Override
            public void perform(IGuiElement element)
            {
                Schematic selectedSchematic = schematics.size() > 0 ? schematics.get(getScroll()) : null;

                if (selectedSchematic != null)
                {
                    AssemblyManager.handleAssembly(selectedSchematic, Game.minecraft().player);
                    AliensVsPredator.network().sendToServer(new PacketAssemble(selectedSchematic.getName(), 64));
                }
            }
        });

        this.buttonScrollDown.x = this.guiLeft + this.xSize + 5 - buttonOffsetX;
        this.buttonScrollDown.y = this.guiTop + 3 + (offset += 20);
        this.buttonScrollDown.width = buttonWidth;
        this.buttonScrollDown.height = 19;
        this.buttonScrollDown.displayString = "\u21e9";
        this.buttonScrollDown.baseColor = this.getScroll() >= (this.schematics.size() - 1) ? 0x22000000 : 0xAA000000;
        this.buttonScrollDown.overlayColorHover = 0x22FFFFFF;
        this.buttonScrollDown.drawButton();
        this.buttonScrollDown.setAction(new IAction() {
            @Override
            public void perform(IGuiElement element)
            {
                scrollUp();
            }
        });
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException
    {
        this.scroll = 0;

        this.searchBar.textboxKeyTyped(typedChar, keyCode);

        if (!(keyCode == Keyboard.KEY_E && this.searchBar.isFocused()))
        {
            super.keyTyped(typedChar, keyCode);
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

        ArrayList<Schematic> searchedSchematics = new ArrayList<Schematic>();

        for (Schematic schematic : AssemblyManager.instance.schematics())
        {
            if (schematic != null && schematic.getItemStackAssembled() != null)
            {
                Item item = schematic.getItemStackAssembled().getItem();

                if (item != null && schematic.getItemStackAssembled().getDisplayName().toLowerCase().contains(this.searchBar.getText().toLowerCase()))
                {
                    searchedSchematics.add(schematic);
                }
            }
        }
        this.schematics = searchedSchematics;
    }

    public void scrollDown()
    {
        if (this.scroll >= 1)
        {
            this.scroll -= 1;
        }
    }

    public void scrollUp()
    {
        if (this.scroll < this.schematics.size() - 1)
        {
            this.scroll += 1;
        }
    }

    public int getScroll()
    {
        return this.scroll;
    }
}
