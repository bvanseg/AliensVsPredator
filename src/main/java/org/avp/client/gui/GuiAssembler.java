package org.avp.client.gui;

import com.asx.mdx.lib.client.gui.GuiCustomButton;
import com.asx.mdx.lib.client.gui.GuiCustomTextbox;
import com.asx.mdx.lib.client.gui.IAction;
import com.asx.mdx.lib.client.gui.IGuiElement;
import com.asx.mdx.lib.client.util.Draw;
import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.util.Game;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.avp.AVP;
import org.avp.common.item.crafting.AssemblyManager;
import org.avp.common.item.crafting.Schematic;
import org.avp.common.packets.server.PacketAssemble;
import org.avp.common.tile.TileEntityAssembler;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GuiAssembler extends GuiContainer
{
	private static final List<Schematic> sortedSchematics = new ArrayList<>(AssemblyManager.instance.schematics());
    private static final GuiCustomButton  buttonScrollUp = new GuiCustomButton(0, 0, 0, 20, 20, "");
    private static final GuiCustomButton  buttonScrollDown = new GuiCustomButton(1, 0, 0, 20, 20, "");
    private static final GuiCustomButton  buttonAssemble = new GuiCustomButton(2, 0, 0, 50, 20, "");
    private static final GuiCustomButton  buttonAssemble4 = new GuiCustomButton(2, 0, 0, 50, 20, "");
    private static final GuiCustomButton  buttonAssemble8 = new GuiCustomButton(2, 0, 0, 50, 20, "");
    private static final GuiCustomButton  buttonAssemble16 = new GuiCustomButton(2, 0, 0, 50, 20, "");
    private static final GuiCustomButton  buttonAssemble32 = new GuiCustomButton(2, 0, 0, 50, 20, "");
    private static final GuiCustomButton  buttonAssembleStack = new GuiCustomButton(2, 0, 0, 50, 20, "");

    private static final GuiCustomTextbox searchBar = new GuiCustomTextbox(0, 0, 100, 20);
    
    private static final IAction scrollUpAction = (IGuiElement element) -> scrollUp();
    private static final IAction scrollDownAction = (IGuiElement element) -> scrollDown();

    private static ArrayList<Schematic> schematics;
    private static int requestedAmount = 1;
    private static int scroll = 0;
    private static int maxAssemblyAmount = 0;
    private static boolean searchRequiresUpdate = true;
    private static boolean assemblyRequiresUpdate = true;
    
    private static final IAction assembleAction = (IGuiElement element) -> {
    	Schematic selectedSchematic = schematics.size() > 0 ? schematics.get(getScroll()) : null;

        if (selectedSchematic != null)
        {
            AssemblyManager.handleAssembly(selectedSchematic, Game.minecraft().player);
            AVP.network().sendToServer(new PacketAssemble(selectedSchematic.getName(), requestedAmount));
        }
    };
    
    static {
    	sortedSchematics.sort((a, b) -> {
    		String c = I18n.translateToLocal(a.getItemStackAssembled().getItem().getTranslationKey() + ".name");
    		String d = I18n.translateToLocal(b.getItemStackAssembled().getItem().getTranslationKey() + ".name");
    		return c.compareTo(d);
    	});
    	schematics = new ArrayList<>(AssemblyManager.instance.schematics());
    	
        searchBar.setWidth(208);
        searchBar.setHeight(15);
        searchBar.setBackgroundColor(0xFF000000);
        searchBar.setTextColor(0xFF88FF00);
        
        int buttonWidth = 38;
        
        buttonScrollUp.width = buttonWidth;
        buttonScrollUp.height = 19;
        buttonScrollUp.displayString = "\u21e7";
        buttonScrollUp.overlayColorHover = 0x22FFFFFF;
        buttonScrollUp.setAction(scrollUpAction);

        initAssembleButton(buttonAssemble, 1);
        initAssembleButton(buttonAssemble4, 4);
        initAssembleButton(buttonAssemble8, 8);
        initAssembleButton(buttonAssemble16, 16);
        initAssembleButton(buttonAssemble32, 32);
        initAssembleButton(buttonAssembleStack, 64);
        
        buttonScrollDown.width = buttonWidth;
        buttonScrollDown.height = 19;
        buttonScrollDown.displayString = "\u21e9";
        buttonScrollDown.overlayColorHover = 0x22FFFFFF;
        buttonScrollDown.setAction(scrollDownAction);
    }
    
    private static void initAssembleButton(GuiCustomButton button, int count) {
        int buttonWidth = 38;
        
        button.displayString = "\u2692 x" + count;
        button.width = buttonWidth;
        button.fontShadow = false;
        button.setAction((e) -> {
        	requestedAmount = count;
        	assembleAction.perform(e);
        });
    }

    public GuiAssembler(InventoryPlayer invPlayer, TileEntityAssembler assembler, World world, int x, int y, int z)
    {
        super(assembler.getNewContainer(invPlayer.player));
        this.xSize = 256;
        this.ySize = 170;
        this.allowUserInput = true;
    }

    @Override
    public void initGui()
    {
        super.initGui();
        
        scroll = 0;
        requestedAmount = 1;
        assemblyRequiresUpdate = true;
        searchRequiresUpdate = true;
        schematics = new ArrayList<>(AssemblyManager.instance.schematics());
        searchBar.setText("");

        int buttonWidth = 38;
        int buttonOffsetX = buttonWidth + 9;
        int offset = 0;
        
        searchBar.setFocused(true);
        searchBar.setX(this.guiLeft + 4);
        searchBar.setY(this.guiTop + 17);

        buttonScrollUp.x = this.guiLeft + xSize + 5 - buttonOffsetX;
        buttonScrollUp.y = this.guiTop + 4;
        
        this.offsetAssembleButton(buttonAssemble, buttonOffsetX, offset += 20);
        this.offsetAssembleButton(buttonAssemble4, buttonOffsetX, offset += 20);
        this.offsetAssembleButton(buttonAssemble8, buttonOffsetX, offset += 20);
        this.offsetAssembleButton(buttonAssemble16, buttonOffsetX, offset += 20);
        this.offsetAssembleButton(buttonAssemble32, buttonOffsetX, offset += 20);
        this.offsetAssembleButton(buttonAssembleStack, buttonOffsetX, offset += 20);

        buttonScrollDown.x = this.guiLeft + this.xSize + 5 - buttonOffsetX;
        buttonScrollDown.y = this.guiTop + 3 + (offset += 20);
    }
    
    private void offsetAssembleButton(GuiCustomButton button, int buttonOffsetX, int offset) {
    	button.x = (this.guiLeft + this.xSize + 5) - buttonOffsetX;
        button.y = this.guiTop + 3 + (offset);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        if (schematics != null && schematics.size() > 0)
        {
            drawMaterialsSidebar();
            drawSchematicListItems();
        }

        super.drawGuiContainerForegroundLayer(mouseX, mouseY);
    }

	private void drawMaterialsSidebar() {
		if (schematics.isEmpty()) return;
		
		Schematic selectedSchematic = schematics.get(getScroll());

		int currentStack = -1;
	    int progress = 0;
	    int maxProgress = 0;
	    int assemblerSidePanelWidth = ((this.width - this.xSize) / 2) - 5;
	    int assemblerSidePanelX = -assemblerSidePanelWidth;

        OpenGL.enableBlend();
	    for (ItemStack stack : selectedSchematic.getItemsRequired())
	    {
	        currentStack++;
	        int amountOfStack = AssemblyManager.amountForMatchingStack(Game.minecraft().player, stack);
	        int stackY = 15 + (currentStack * 8);
	        int currentStackSize = (amountOfStack > stack.getCount() ? stack.getCount() : amountOfStack);
	        Draw.drawRect(assemblerSidePanelX, stackY - 2, assemblerSidePanelWidth, 8, 0xDD000000);

	        OpenGL.pushMatrix();
	        {
	            float s = 0.5F;
	            float m = 1F / s;
	            int textColor = currentStackSize >= stack.getCount() ? 0xFF00AAFF : currentStackSize < stack.getCount() && currentStackSize > 0 ? 0xFFFFAA00 : 0xFF888888;

	            OpenGL.scale(s, s, 1.0F);
	            Draw.drawString(currentStackSize + "/" + stack.getCount(), Math.round((-12) * m), Math.round((stackY) * m), textColor, false);
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
	}

    /**
     * Draw the schematics in the assembler
     */
	private void drawSchematicListItems() {
		List<Schematic> visibleSchematics = schematics.subList(getScroll(), Math.min(getScroll() + 10, schematics.size()));
		
		int i = getScroll();
        int entryHeight = 10;
        int entryX = 4;

        OpenGL.disableBlend();
		for (Schematic schematic : visibleSchematics) {
			ItemStack itemStack = schematic.getItemStackAssembled();
			Item item = itemStack.getItem();
	        
	        if (item != null && itemStack.getDisplayName().toLowerCase().contains(searchBar.getText().toLowerCase()))
	        {
	            int numberRendered = i - (getScroll());
	            int entryWidth = this.xSize - Math.round(this.xSize / 5.35F);
	            int entryY = 33 + (numberRendered) * entryHeight;
	            
                Draw.drawRect(entryX, entryY + entryHeight, entryWidth, 1, 0xFF000000);
                Draw.drawString(I18n.translateToLocal(item.getTranslationKey() + ".name"), entryX + 13, entryY + 2, numberRendered == 0 ? 0xFF00AAFF : 0xFF555555, false);
                Draw.drawItem(schematic.getItemStackAssembled(), entryX + 2, entryY + 2, 8, 8);
	        }
			
	        i++;
		}
	}

    @SideOnly(Side.CLIENT)
    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int x, int y)
    {
    	this.drawDefaultBackground();
        AVP.resources().GUI_ASSEMBLER.bind();
        drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float renderPartial)
    {
        super.drawScreen(mouseX, mouseY, renderPartial);
        
        searchBar.drawTextBox();

        buttonScrollUp.baseColor = getScroll() == 0 ? 0x22000000 : 0xAA000000;
        buttonScrollUp.drawButton();

        if (assemblyRequiresUpdate) {
        	maxAssemblyAmount = AssemblyManager.tryAssemblyMax(Game.minecraft().player, schematics.size() > 0 ? schematics.size() > 0 ? schematics.get(getScroll()) : null : null, true);
        	assemblyRequiresUpdate = false;
        }
        
        this.drawAssembleButton(buttonAssemble, maxAssemblyAmount >= 1);
        this.drawAssembleButton(buttonAssemble4, maxAssemblyAmount >= 4);
        this.drawAssembleButton(buttonAssemble8, maxAssemblyAmount >= 8);
        this.drawAssembleButton(buttonAssemble16, maxAssemblyAmount >= 16);
        this.drawAssembleButton(buttonAssemble32, maxAssemblyAmount >= 32);
        this.drawAssembleButton(buttonAssembleStack, maxAssemblyAmount >= 64);

        buttonScrollDown.baseColor = getScroll() >= (schematics.size() - 1) ? 0x22000000 : 0xAA000000;
        buttonScrollDown.drawButton();
    }

	private void drawAssembleButton(GuiCustomButton button, boolean hasMaterials) {
		button.baseColor = hasMaterials ? 0xAA000000 : 0x22000000;
		button.overlayColorHover = hasMaterials ? 0xFF88FF00 : 0xFFFF0000;
		button.fontColor = button.isMouseOver() ? 0xFF000000 : 0xFFFFFFFF;
		button.drawButton();
	}

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException
    {
    	if (keyCode != Keyboard.KEY_DOWN &&
    			keyCode != Keyboard.KEY_UP &&
    			keyCode != Keyboard.KEY_CAPITAL &&
    			keyCode != Keyboard.KEY_LSHIFT) {
    		scroll = 0;
            searchBar.textboxKeyTyped(typedChar, keyCode);
            searchRequiresUpdate = true;
    	}

        if (!(keyCode == Keyboard.KEY_E && searchBar.isFocused()))
        {
            super.keyTyped(typedChar, keyCode);
        }
    }

    @Override
    public void updateScreen()
    {
        super.updateScreen();

        int dWheel = Mouse.getDWheel();

        if (dWheel > 0) {
            scrollUp();
        }
        else if (dWheel < 0) {
            scrollDown();
        }

        if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
            scrollDown();
        }

        if (Keyboard.isKeyDown(Keyboard.KEY_UP)) {
            scrollUp();
        }

        if (searchRequiresUpdate) {
            ArrayList<Schematic> searchedSchematics = new ArrayList<Schematic>();

            for (Schematic schematic : sortedSchematics)
            {
                if (schematic != null && schematic.getItemStackAssembled() != null)
                {
                    Item item = schematic.getItemStackAssembled().getItem();

                    if (item != null && schematic.getItemStackAssembled().getDisplayName().toLowerCase().contains(searchBar.getText().toLowerCase()))
                    {
                        searchedSchematics.add(schematic);
                    }
                }
            }
            schematics = searchedSchematics;
            searchRequiresUpdate = false;
        }
    }

    public static void scrollDown()
    {
        if (scroll < schematics.size() - 1) {
            scroll += 1;
            assemblyRequiresUpdate = true;
        }
    }

    public static void scrollUp()
    {
        if (scroll >= 1) {
            scroll -= 1;
            assemblyRequiresUpdate = true;
        }
    }

    public static int getScroll()
    {
        return scroll;
    }
}
