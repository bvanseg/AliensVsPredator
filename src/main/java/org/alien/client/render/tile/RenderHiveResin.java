package org.alien.client.render.tile;

import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.model.Model;
import com.asx.mdx.common.io.config.GraphicsSetting;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.init.Blocks;
import org.alien.client.AlienResources;
import org.alien.client.model.tile.ModelHiveResin;
import org.alien.common.tile.TileEntityHiveResin;
import org.avp.common.config.ModelConfig;

public class RenderHiveResin extends TileEntitySpecialRenderer<TileEntityHiveResin>
{
    @Override
    public void render(TileEntityHiveResin tile, double posX, double posY, double posZ, float partialTicks, int destroyStage, float alpha)
    {
        GraphicsSetting hiveTessellation = ModelConfig.getInstance().getGraphics().hiveTessellation;

        if (hiveTessellation == GraphicsSetting.MEDIUM || hiveTessellation == GraphicsSetting.HIGH || hiveTessellation == GraphicsSetting.ULTRA)
        {
            TileEntityHiveResin resin = tile;

            OpenGL.pushMatrix();
            {
                OpenGL.translate(posX + 0.5, posY - 0.5, posZ + 0.5);

                AlienResources.Models.HIVE_RESIN.bindTexture();
                ModelHiveResin model = AlienResources.Models.HIVE_RESIN.getModel();
                OpenGL.enableCullFace();

                /** TOP **/
                if (resin.topBlock == Blocks.AIR)
                {
                    if (hiveTessellation == GraphicsSetting.MEDIUM || hiveTessellation == GraphicsSetting.HIGH || hiveTessellation == GraphicsSetting.ULTRA)
                    {
                        model.blockFaceTop.offsetY = 2.002F;
                        model.blockFaceTop.rotateAngleX = (float) Math.toRadians(180);
                        model.blockFaceTop.render(Model.DEFAULT_SCALE);
                    }
                }

                /** BOTTOM **/
                if (resin.bottomBlock == Blocks.AIR)
                {
                    if (hiveTessellation == GraphicsSetting.HIGH || hiveTessellation == GraphicsSetting.ULTRA)
                    {
                        model.bResinRibCenter.offsetY = -0.9F;
                        model.bResinRibCenter.rotateAngleX = (float) Math.toRadians(180);
                        model.bResinRibCenter.render(Model.DEFAULT_SCALE);
                    }
                }

                OpenGL.rotate(resin.getVariant() == null ? 0 : (resin.getVariant().id - 1) * 90F, 0F, 1F, 0F);

                /** NORTH **/
                if (hiveTessellation == GraphicsSetting.HIGH || hiveTessellation == GraphicsSetting.ULTRA)
                {
                    model.nBottomRoot01.isHidden = resin.northTopBlock == Blocks.AIR;
                    model.nTopRoot01.isHidden = resin.northBottomBlock == Blocks.AIR;
                }

                if (resin.northBlock == Blocks.AIR)
                {
                    if (hiveTessellation == GraphicsSetting.HIGH || hiveTessellation == GraphicsSetting.ULTRA)
                    {
                        model.nResinRipCenter.render(Model.DEFAULT_SCALE);
                    }

                    if (hiveTessellation == GraphicsSetting.MEDIUM || hiveTessellation == GraphicsSetting.ULTRA)
                    {
                        model.webbing01.render(Model.DEFAULT_SCALE);
                        model.webbing15.render(Model.DEFAULT_SCALE);
                        model.webbing07.render(Model.DEFAULT_SCALE);
                        model.webbing13.render(Model.DEFAULT_SCALE);
                        model.webbing09.render(Model.DEFAULT_SCALE);
                    }
                }

                /** WEST **/
                if (hiveTessellation == GraphicsSetting.HIGH || hiveTessellation == GraphicsSetting.ULTRA)
                {
                    model.wBottomRoot01.isHidden = resin.westTopBlock == Blocks.AIR;
                    model.wTopRoot01.isHidden = resin.westBottomBlock == Blocks.AIR;
                }

                if (resin.westBlock == Blocks.AIR)
                {
                    if (hiveTessellation == GraphicsSetting.HIGH || hiveTessellation == GraphicsSetting.ULTRA)
                    {
                        model.wResinRipCenter.render(Model.DEFAULT_SCALE);
                    }

                    if (hiveTessellation == GraphicsSetting.MEDIUM || hiveTessellation == GraphicsSetting.ULTRA)
                    {
                        model.webbing11.render(Model.DEFAULT_SCALE);
                        model.webbing04.render(Model.DEFAULT_SCALE);
                        model.webbing05.render(Model.DEFAULT_SCALE);
                    }
                }

                /** SOUTH **/
                if (hiveTessellation == GraphicsSetting.HIGH || hiveTessellation == GraphicsSetting.ULTRA)
                {
                    model.sBottomRoot01.isHidden = resin.southTopBlock == Blocks.AIR;
                    model.sTopRoot01.isHidden = resin.southBottomBlock == Blocks.AIR;
                }

                if (resin.southBlock == Blocks.AIR)
                {
                    if (hiveTessellation == GraphicsSetting.HIGH || hiveTessellation == GraphicsSetting.ULTRA)
                    {
                        model.sResinRipCenter.render(Model.DEFAULT_SCALE);
                    }

                    if (hiveTessellation == GraphicsSetting.MEDIUM || hiveTessellation == GraphicsSetting.ULTRA)
                    {
                        model.webbing14.render(Model.DEFAULT_SCALE);
                        model.webbing06.render(Model.DEFAULT_SCALE);
                        model.webbing10.render(Model.DEFAULT_SCALE);
                        model.webbing03.render(Model.DEFAULT_SCALE);
                    }
                }

                /** EAST **/
                if (hiveTessellation == GraphicsSetting.HIGH || hiveTessellation == GraphicsSetting.ULTRA)
                {
                    model.eBottomRoot01.isHidden = resin.eastTopBlock == Blocks.AIR;
                    model.eTopRoot01.isHidden = resin.eastBottomBlock == Blocks.AIR;
                }

                if (resin.eastBlock == Blocks.AIR)
                {
                    if (hiveTessellation == GraphicsSetting.HIGH || hiveTessellation == GraphicsSetting.ULTRA)
                    {
                        model.eResinRipCenter.render(Model.DEFAULT_SCALE);
                    }

                    if (hiveTessellation == GraphicsSetting.MEDIUM || hiveTessellation == GraphicsSetting.ULTRA)
                    {
                        model.webbing12.render(Model.DEFAULT_SCALE);
                        model.webbing08.render(Model.DEFAULT_SCALE);
                        model.webbing02.render(Model.DEFAULT_SCALE);
                    }
                }
            }
            OpenGL.popMatrix();
        }
    }
}
