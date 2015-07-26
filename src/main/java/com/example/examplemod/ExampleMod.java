package com.example.examplemod;


import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
public class ExampleMod
{
    public static final String MODID = "examplemod";
    public static final String VERSION = "1.0";
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		// some example code
        System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());
        MinecraftForge.EVENT_BUS.register(new MyEventHandler());
    }
}

class MyEventHandler {
    @SubscribeEvent
    public void onPlayerJoin(EntityJoinWorldEvent entityEvent) {
        if (entityEvent.entity instanceof EntityPlayer) {
            World world = entityEvent.world;
            EntityPlayer player = (EntityPlayer) entityEvent.entity;

            BlockPos pozycjaGracza = new BlockPos(player.posX, player.posY, player.posZ);
            BlockPos pozycjaPowietrza = new BlockPos(player.posX,player.posY,player.posZ);
            zbudujDom(pozycjaGracza, world);

        }
    }

    private void zbudujDom(BlockPos pozycjaGracza, World swiat) {
        zbudujPodloge(pozycjaGracza,swiat);
        zbudujLewaSciane(pozycjaGracza, swiat);
        zbudujPrzedniaSciane(pozycjaGracza, swiat);
        zbudujTylnaSciane(pozycjaGracza, swiat);
        zbudujPrawaSciane(pozycjaGracza, swiat);
        zbudujDach(pozycjaGracza, swiat);
        wypelnijwnetrze(pozycjaGracza, swiat);

    }

    private void zbudujPodloge(BlockPos pozycjaGracza, World swiat){
        for (int i=0;i<10;i++) {

            double posZ = pozycjaGracza.getZ()+i;
            for (int j = 0; j < 10; j++) {
                BlockPos pozycjaObsidian = new BlockPos(pozycjaGracza.getX() + 1 + j, pozycjaGracza.getY(), posZ);
                swiat.setBlockState(pozycjaObsidian, Blocks.obsidian.getDefaultState());
            }
        }
    }

    private void zbudujLewaSciane(BlockPos pozycjaGracza, World swiat){
        for (int i=0;i<5;i++) {
            double posY=pozycjaGracza.getY()+i;
            for (int j = 0; j < 10; j++) {
                BlockPos pozycjaObsidian = new BlockPos(pozycjaGracza.getX() + 1 + j, posY, pozycjaGracza.getZ());
                swiat.setBlockState(pozycjaObsidian, Blocks.obsidian.getDefaultState());
            }
        }
    }

    private void zbudujPrawaSciane(BlockPos pozycjaGracza, World swiat){
        for(int i=0;i<5;i++) {
            double posY=pozycjaGracza.getY()+i;
            for (int j = 0; j < 10; j++) {
                BlockPos pozycjaObsidian = new BlockPos(pozycjaGracza.getX() + 1 + j, posY, pozycjaGracza.getZ()+10);
                swiat.setBlockState(pozycjaObsidian, Blocks.obsidian.getDefaultState());
            }
        }
    }

    private void zbudujPrzedniaSciane(BlockPos pozycjaGracza, World swiat){
        for (int i=0;i<5;i++) {
            double posY=pozycjaGracza.getY()+i;
            for (int j = 0; j < 10; j++) {
                BlockPos pozycjaObsidian = new BlockPos(pozycjaGracza.getX() + 1, posY, pozycjaGracza.getZ() + j);
                swiat.setBlockState(pozycjaObsidian, Blocks.obsidian.getDefaultState());
            }
        }
        zrobDrzwi(pozycjaGracza,swiat);


    }

    private void zbudujTylnaSciane(BlockPos pozycjaGracza, World swiat){
        for (int i=0;i<5;i++) {
            double posY=pozycjaGracza.getY()+i;
            for (int j = 0; j < 10; j++) {
                BlockPos pozycjaObsidian = new BlockPos(pozycjaGracza.getX() + 10, posY, pozycjaGracza.getZ()+j);
                swiat.setBlockState(pozycjaObsidian, Blocks.obsidian.getDefaultState());
            }
        }
    }

    private void zbudujDach(BlockPos pozycjaGracza, World swiat){
        for (int i=0;i<10;i++) {
            double posZ = pozycjaGracza.getZ() + i;
            for (int j = 0; j < 10; j++) {
                BlockPos pozycjaObsidian = new BlockPos(pozycjaGracza.getX() +j, pozycjaGracza.getY()+5, posZ);
                swiat.setBlockState(pozycjaObsidian, Blocks.obsidian.getDefaultState());
            }
        }
    }

    private void wypelnijwnetrze(BlockPos pozycjaGracza, World swiat){
        for(int i=1;i<5;i++) {
            double posY=pozycjaGracza.getY()+i;
            for (int j = 1; j < 10; j++) {
                double posZ = pozycjaGracza.getZ() + j;
                for (int k = 1; k < 9; k++) {
                    BlockPos pozycjaPowietrza = new BlockPos(pozycjaGracza.getX()+1+k, posY, posZ);
                    swiat.setBlockState(pozycjaPowietrza, Blocks.air.getDefaultState());
                }
            }
        }
    }

    private void zrobDrzwi(BlockPos pozycjaGracza, World swiat){
        for(int i=1;i<3;i++){
            BlockPos pozycjaObsidian = new BlockPos(pozycjaGracza.getX() + 1, pozycjaGracza.getY()+i, pozycjaGracza.getZ()+2);
            swiat.setBlockState(pozycjaObsidian, Blocks.air.getDefaultState());
        }
    }
}

