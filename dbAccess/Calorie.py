from product.models import Info
from django.db import connection

def getCalorieByUnitItem(unit, item):
    c = connection.cursor()
    calorie = c.execute('SELECT calorie FROM product_info WHERE unit = %s AND item = %s', [unit, item])
    return calorie