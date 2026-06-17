from pathlib import Path
import json

fruits = ["cherry", "lychee", "dragonfruit", 'grape']
out_dir = Path(r"C:\Users\prabh\Desktop\fruitcraft-template-1.21.11\src\main\resources\assets\fruitcraft\models\block")

for fruit in fruits:
    for stage in range(4):
        data = {
        "parent": "minecraft:block/crop",
            "textures": {
            "crop": f"fruitcraft:block/{fruit}_crop_stage{stage}"
            }
        }
        path = out_dir / f"{fruit}_crop_stage{stage}.json"
        path.write_text(json.dumps(data, indent=2))