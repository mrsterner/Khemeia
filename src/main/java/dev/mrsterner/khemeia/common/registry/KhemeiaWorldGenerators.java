package dev.mrsterner.khemeia.common.registry;

import dev.mrsterner.khemeia.Khemeia;
import dev.mrsterner.khemeia.mixin.SimpleBlockStateProviderMixin;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.decorator.RarityFilterPlacementModifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.FeatureSize;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.AcaciaFoliagePlacer;
import net.minecraft.world.gen.trunk.ForkingTrunkPlacer;

public class KhemeiaWorldGenerators {
    private static final FeatureSize EMPTY_SIZE = new TwoLayersFeatureSize(0, 0, 0);

    public static final ConfiguredFeature<TreeFeatureConfig, ?> CEDAR_TREE = Feature.TREE.configure(
    new TreeFeatureConfig.Builder(SimpleBlockStateProviderMixin.callInit(KhemeiaObjects.CEDAR_LOG.getDefaultState()), new ForkingTrunkPlacer(5, 0, 0),
    SimpleBlockStateProviderMixin.callInit(KhemeiaObjects.CEDAR_LEAVES.getDefaultState()), new AcaciaFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0)), EMPTY_SIZE).ignoreVines().build());

    public static final PlacedFeature CEDAR_TREE_WITH_CHANCE = CEDAR_TREE.withPlacement(VegetationPlacedFeatures.modifiersWithWouldSurvive(RarityFilterPlacementModifier.of(10), KhemeiaObjects.CEDAR_SAPLING));


    public static void init() {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Khemeia.MODID, "cedar_tree"), CEDAR_TREE);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(Khemeia.MODID, "cedar_tree"), CEDAR_TREE_WITH_CHANCE);
    }
}
