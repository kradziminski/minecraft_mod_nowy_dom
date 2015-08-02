package net.minecraft.kamil.mod;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = ModKamila.MODID, version = ModKamila.VERSION)
public class ModKamila
{
    public static final String MODID = "mod_kamila";
    public static final String VERSION = "1.0";
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new BudowniczyDomow());
    }
}

class BudowniczyDomow {
    @SubscribeEvent
    public void onPlayerJoin(EntityJoinWorldEvent entityEvent) {
        if (entityEvent.entity instanceof EntityPlayer) {
            World world = entityEvent.world;
            EntityPlayer player = (EntityPlayer) entityEvent.entity;

            BlockPos pozycjaGracza = new BlockPos(player.posX, player.posY, player.posZ);
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
        dodajSkrzynke(pozycjaGracza,swiat);

    }

    private void dodajSkrzynke(BlockPos pozycjaGracza, World swiat){
        double skrzynkaPozX = pozycjaGracza.getX() + 2.0;
        double skrzynkaPozY = pozycjaGracza.getY() + 1.0;
        double skrzynkaPozZ = pozycjaGracza.getZ() + 1.0;

        BlockPos pozycjaSkrzynki = new BlockPos(skrzynkaPozX, skrzynkaPozY, skrzynkaPozZ);
        swiat.setBlockState(pozycjaSkrzynki, Blocks.chest.getDefaultState());

        TileEntity byt = swiat.getTileEntity(pozycjaSkrzynki);
        if (byt instanceof TileEntityChest) {
            TileEntityChest skrzynka = (TileEntityChest) byt;
            skrzynka.setInventorySlotContents(0, new ItemStack(Item.getByNameOrId("minecraft:diamond_sword"), 64));
            skrzynka.setInventorySlotContents(1, new ItemStack(Item.getByNameOrId("minecraft:diamond_pickaxe"), 64));
            skrzynka.setInventorySlotContents(2, new ItemStack(Item.getByNameOrId("minecraft:diamond_leggings"), 64));
            skrzynka.setInventorySlotContents(3, new ItemStack(Item.getByNameOrId("minecraft:diamond_helmet"), 64));
            skrzynka.setInventorySlotContents(4, new ItemStack(Item.getByNameOrId("minecraft:diamond_chestplate"), 64));
            skrzynka.setInventorySlotContents(5, new ItemStack(Item.getByNameOrId("minecraft:diamond_boots"), 64));
            for (int i = 0; i < 10; i++) {
                skrzynka.setInventorySlotContents(5 + i, new ItemStack(Item.getByNameOrId("minecraft:torch"), 64));
            }
        }
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

