"""
Week 2 Exercise — CSV processing with context managers.

TODO:
1. Read starter_code/data/sales.csv using csv.DictReader and with open(...).
2. Compute rows count, grand total (sum of units * unit_price), average line revenue.
3. Find SKU with max line revenue (tie: first in file).
4. Write output/summary.txt using with open(..., "w", encoding="utf-8").
"""

from __future__ import annotations
import csv
import sys


# csv_path = "./Data/sales.csv"
# # csv_path = "Data/sales.csv"
# # csv_path = "./data/sales.csv"
# output_path = "./output/summary.txt"





def main() -> None:


    units = 0
    unit_price = 0.00
    bad_count = 0
    number_rows = 0
    total_item_price = 0
    grand_total = 0
    average_line_revenue = 0
    top_line_revenue = 0
    top_sku = 0


    # TODO : Open `data/sales.csv` with `csv.DictReader`, `encoding="utf-8"`, `newline=""`
    # with open("Data/sales.csv", "r", newline="", encoding="utf-8") as File:
    with open("sales.csv", "r", newline="", encoding="utf-8") as File:
        Reader=csv.DictReader(File)
        DataSet = list(Reader)

    # file=open(csv_path, "wb")


    # TODO : - Parse `units` and `unit_price` as numbers (`int` / `float` as appropriate).
    # - Skip or fail gracefully on malformed rows (optional stretch: log count of bad rows to stderr).
    for data in DataSet:
        try:
            units = int(data['units'])
            unit_price = float(data['unit_price'])
            total_item_price = units*unit_price
            grand_total = grand_total + total_item_price
            number_rows = number_rows + 1

            if (total_item_price>top_line_revenue):
                top_line_revenue = total_item_price
                top_sku = data["sku"]

        except ValueError as e:
            bad_count = bad_count + 1


    average_line_revenue = grand_total/number_rows



    # TODO : Use a **second** `with open(..., "w", encoding="utf-8")` targeting `output/summary.txt` (path relative to `starter_code/` or project root—pick one and document it in a comment)
    with open("./output/summary.txt", "w", encoding="utf-8") as File:
        File.write(f"rows = {len(rows)}\n")   

        # TODO : - Write plain text, human-readable lines, for example:
        # ```text
        # rows=...
        # grand_total=...
        # average_line_revenue=...
        # top_sku=...
        # top_line_revenue=...
        # ```
        File.write("="*40+"\n")
        File.write(f"Count Of Bad Rows : {bad_count}\n")
        File.write("="*40+"\n")
        File.write(f"Total Number Of Rows : {number_rows}\n")
        File.write(f"Grand Total : {grand_total}\n")
        File.write(f"Average Line Revenue : {average_line_revenue}\n")
        File.write(f"Top SKU : {top_sku}\n")
        File.write(f"Top Line Revenue : {top_line_revenue}\n")
        File.write("="*40+"\n")
    

    # raise NotImplementedError("Complete this exercise")


if __name__ == "__main__":
    main()
