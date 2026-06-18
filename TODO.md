# Fruitcraft TODO

## Current State
- Mango tree: full wood chain, worldgen in all overworld biomes
- 4 fruit crops: cherry, grape, lychee, dragonfruit (4-stage growth, Fortune loot tables)
- Food items with potion effects: mango (glowing), cherry (jump boost), grapes (night vision), lychee (haste), dragonfruit (levitation)
- Dried mango (smelting), fruit salad (shaped crafting)
- 1 advancement: "Infinity Bowl" (craft fruit salad)
- Vanilla cherry leaves -> fruitcraft:cherry (5% drop)

---

## Phase 1: Polish & Fix Existing Content

- [x] **Potion effect durations are 6 seconds — way too short.** Bump to 30s minimum, 60s for rarer fruits (dragonfruit levitation at 60s would be terrifying and fun)
- [x] **First seeds problem**: player has no way to get the first cherry/grape/lychee/dragonfruit seeds except from crops that don't exist yet. Add seeds to dungeon loot tables, or let wandering trader sell them, or drop from tall grass
- [x] **Fruit salad recipe is incomplete**: only uses mango, cherry, lychee — grapes and dragonfruit are items but not in any recipe. Add them or update the salad
- [x] **Composter support**: add all fruits, seeds, and mango leaves to minecraft:blocks/compostable and minecraft:items/compostable tags
- [x] **Smoker support**: dried mango should be cookable in smoker (faster), not just furnace — add smoker recipe
- [x] **Mango leaves don't flicker/animate**: verify the MangoLeavesBlock has isSolidRender returning false and isViewBlocking returning false for proper transparency
- [x] **Mango spawn rate**: 3 per chunk is dense. Tune down to 1-2 per chunk or add rarity placement modifier

---

## Phase 2: Complete the Mango Wood Set

Right now mango has log/wood/stripped log/planks. Vanilla wood has 11 variants. Add the missing ones — players will expect them.

- [x] Mango Stairs (from planks)
- [ ] Mango Slab (from planks)
- [ ] Mango Fence (from planks + sticks)
- [ ] Mango Fence Gate (from planks + sticks)
- [ ] Mango Door (from planks)
- [ ] Mango Trapdoor (from planks)
- [ ] Mango Button (from planks)
- [ ] Mango Pressure Plate (from planks)
- [ ] Add all new blocks to the appropriate minecraft tags (wooden_stairs, wooden_slabs, etc.)

---

## Phase 3: New Fruit Trees (Big Content)

The mod is called Fruitcraft but only mango has a tree. Each fruit deserves its own source.

- [ ] **Cherry Tree**: natural cherry blossom-style tree (pink leaves), spawns in flower forests and cherry grove biomes. Drops cherries from leaves (higher rate than vanilla cherry leaves). Cherry sapling grows into it.
- [ ] **Lychee Tree**: medium-height tropical tree, spawns in jungle biomes. Lychee fruit hangs as a feature off the leaves (or just drops from leaves with 10% chance).
- [ ] **Grape Vine**: climbing plant like vines, grows on the sides of stone/dirt. Spawns in savanna or plains. Harvest grapes when fully grown.
- [ ] **Dragonfruit Cactus**: tall, spiky cactus-like plant that grows in desert/badlands. 3-4 blocks tall, drops dragonfruit at full height.

---

## Phase 4: Dried & Preserved Fruits

Dried mango exists — players will expect the pattern to apply to all fruits.

- [ ] Dried Cherry (smelting + smoker)
- [ ] Dried Grapes → Raisins (smelting + smoker)  
- [ ] Dried Lychee (smelting + smoker)
- [ ] Dried Dragonfruit (smelting + smoker)
- [ ] Dried fruits should have higher saturation and longer potion effects than fresh
- [ ] **Trail Mix**: shapeless recipe combining 3 dried fruits → trail mix item with combined weak effects

---

## Phase 5: Juicer Block

A custom block that combines fruits into juice. More interesting than just smelting.

- [ ] **Juicer block**: stone-carved look, right-click UI with 2 ingredient slots + output slot
- [ ] **Mango Juice**: 2 mangoes → 1 mango juice (glass bottle result), glowing effect 90s
- [ ] **Cherry Juice**: 3 cherries → 1 cherry juice, jump boost 90s
- [ ] **Grape Juice**: 3 grapes → 1 grape juice, night vision 90s
- [ ] **Lychee Juice**: 3 lychees → 1 lychee juice, haste 90s
- [ ] **Dragonfruit Juice**: 2 dragonfruits → 1 dragonfruit juice, levitation 30s (op, keep short)
- [ ] **Tropical Smoothie**: combine 3 different juices → tropical smoothie with Luck effect and all 5 weak effects

---

## Phase 6: World Integration

- [ ] **Wandering Trader** sells 1-3 random fruit seeds (rare, 1 trade slot)
- [ ] **Biome-specific worldgen**: lychee tree in jungles, cherry tree in cherry groves + flower forests, dragonfruit cactus in deserts, grape vines in savannas
- [ ] **Fruit can be found in chests**: add mango/cherry/grapes to village farm house loot, dried mango to desert temple loot, dragonfruit to bastion remnant loot (they'd have exotic fruits)
- [ ] **Mango in jungle villages specifically**: bias mango tree gen toward jungle + forest

---

## Phase 7: Golden Fruit Variants

Gold-tier versions with permanent or very long effects.

- [ ] **Golden Mango**: gold ingots + mango (like golden apple) — grants Absorption + Regeneration
- [ ] **Golden Cherry**: gold ingots + cherry — grants Fire Resistance + Speed
- [ ] Better visual (gold-tinted item sprite or custom texture)

---

## Phase 8: More Advancements

One advancement for the whole mod is weak. Add a proper advancement tree.

- [ ] Root advancement: **"A Fruitful Journey"** — pick up any fruit item
- [ ] **"Tropical Tourist"** — eat one of each fruit
- [ ] **"Smooth Operator"** — craft a Tropical Smoothie
- [ ] **"Orchardist"** — grow 4 different fruit crops to full maturity
- [ ] **"Golden Harvest"** — craft a Golden Mango
- [ ] **"Floating Away"** — consume dragonfruit and reach max height (levitation + height check)
- [ ] **"Infinity Bowl"** — keep as final advancement, move under "Smooth Operator"

---

## Phase 9: Quality of Life & Polish

- [ ] **Custom eating sounds**: juicy squelch sound when eating fruits (reuse vanilla sounds or add custom)
- [ ] **Particles on eating**: green leaf particles when eating mango, pink petals when eating cherry
- [ ] **Fruit salad in bowl**: fruit_salad item should return a bowl to player after eating (like mushroom stew)
- [ ] **JEI/REI compat**: ensure all recipes show up properly (they should by default, but verify)
- [ ] **Tooltip info**: add lore to fruit items showing the potion effect they grant
- [ ] **Stripped mango wood**: add stripped_mango_wood block (currently only stripped_mango_log exists)

---

## Icebox (Nice but Not Priority)

- Fruit basket block (decorative storage for fruits, 9 slots, same fruit only)
- Fruit-dyed candles or banners
- Mango wood boat
- Mango sign + hanging sign
- Fruit crop can be bonemealed to advance 1 stage
- Dragonfruit glows in the dark (emissive texture)
- Mob drops: parrots drop tropical fruit, foxes carry cherries
