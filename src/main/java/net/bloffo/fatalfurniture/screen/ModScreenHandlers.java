package net.bloffo.fatalfurniture.screen;

import net.bloffo.fatalfurniture.FatalFurniture;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.bloffo.fatalfurniture.screen.custom.DrawersScreenHandler;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class ModScreenHandlers {
    public static final ScreenHandlerType<DrawersScreenHandler> DRAWERS_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(FatalFurniture.MOD_ID, "drawers_screen_handler"),
                    new ExtendedScreenHandlerType<>(DrawersScreenHandler::new, BlockPos.PACKET_CODEC));

    public static void registerScreenHandlers() {
        FatalFurniture.LOGGER.info("Registering Screen Handlers for " + FatalFurniture.MOD_ID);
    }
}