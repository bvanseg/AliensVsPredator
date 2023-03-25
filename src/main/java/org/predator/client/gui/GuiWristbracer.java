package org.predator.client.gui;

import com.asx.mdx.client.render.Draw;
import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.gui.GuiCustomButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.EnumDifficulty;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;
import org.predator.client.PredatorResources;
import org.predator.client.PredatorSounds;
import org.predator.common.inventory.ContainerWristbracer;
import org.predator.common.item.ItemWristbracer;

import java.util.ArrayList;
import java.util.List;

public class GuiWristbracer extends GuiContainer
{
    private final int[] displays = new int[6];
    protected List<GuiCustomButton> buttons = new ArrayList<>();
    private final ContainerWristbracer container;

    public GuiWristbracer(EntityPlayer player, ContainerWristbracer container)
    {
        super(container);

        this.container = container;
        this.xSize = 192;
        this.ySize = 156;

        for (int x = 0; x < 6; x++)
        {
            int finalX = x;
            GuiCustomButton button = new GuiCustomButton(x, 0, 0, 50, 100, "X");
            button.setAction(element -> {
                this.mc.world.playSound(this.mc.player, this.mc.player.getPosition(), PredatorSounds.WRISTBRACER_CONSOLE_INTERACT.event(), SoundCategory.NEUTRAL, 1F, 1F);
                updateScreenDigit(button.id, displays[finalX] < 9 ? displays[finalX] + 1 : 0);
            });
            this.buttons.add(button);
            this.displays[x] = 0;
        }
    }

    @Override
    public void initGui()
    {
        this.mc.world.playSound(this.mc.player, this.mc.player.getPosition(), PredatorSounds.WRISTBRACER_CONSOLE_OPEN.event(), SoundCategory.NEUTRAL, 1F, 1F);
        super.initGui();
    }

    @Override
    public void onGuiClosed() {
        this.mc.world.playSound(this.mc.player, this.mc.player.getPosition(), PredatorSounds.WRISTBRACER_CONSOLE_CLOSE.event(), SoundCategory.NEUTRAL, 1F, 1F);
        super.onGuiClosed();
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) { /* Do Nothing */ }

    @SideOnly(Side.CLIENT)
    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int x, int y)
    {
        this.guiLeft = this.width / 2 - xSize / 2;
        this.guiTop = this.height / 2 - ySize / 2;
    	this.drawDefaultBackground();
        PredatorResources.instance.GUI_WRISTBRACER.bind();
        Draw.drawQuad(guiLeft, guiTop, xSize, ySize - 30, 0, 0, 0);

        for (byte hotbarSlotIndex = 0; hotbarSlotIndex < 9; hotbarSlotIndex++)
        {
            Draw.drawRect(guiLeft + 15 + (18 * hotbarSlotIndex), guiTop + 136, 16, 16, 0xAA000000);
        }

        // For each digit slot
        for (int digitSlotIndex = 0; digitSlotIndex < 6; digitSlotIndex++)
        {
            GuiCustomButton button = this.buttons.get(digitSlotIndex);

            if (mc.gameSettings.difficulty == EnumDifficulty.EASY || mc.gameSettings.difficulty == EnumDifficulty.PEACEFUL)
            {
                button.tooltip = String.valueOf(this.displays[digitSlotIndex]);
            }
            else
            {
                button.tooltip = "";
            }

            button.displayString = "";
            button.x = guiLeft + 15 + 27 * digitSlotIndex;
            button.y = guiTop + 49;
            button.width = 25;
            button.height = 28;
            button.baseColor = 0x00000000;
            button.overlayColorHover = 0x22FF0000;
            button.drawButton();

            drawYautjaDigit(this.displays[digitSlotIndex], guiLeft + 13 + 27 * digitSlotIndex, guiTop + 49);

            button.drawTooltip();
        }

        String combination = ItemWristbracer.code(displays[0], displays[1], displays[2], displays[3], displays[4], displays[5]);

        if (ItemWristbracer.isCodeValid(combination))
        {
            ItemWristbracer.getAction(combination).onAction(combination, container);
        }
    }

    public void updateScreenDigit(int displayId, int digit)
    {
        displays[displayId] = digit;
    }

    public static void drawYautjaDigit(int number, int xPos, int yPos)
    {
        // If the number is 0, we do not need to draw anything.
        if (number <= 0) return;

        OpenGL.enable(GL11.GL_BLEND);
        PredatorResources.instance.GUI_WRISTBRACER.bind();
        Draw.drawQuad(xPos, yPos, 28, 50, 0, (27 * (number - 1)), 126);
    }
}
