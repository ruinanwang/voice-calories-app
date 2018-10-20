from product.models import Info

def getCalorieByUnitItem(unit, item):
    calorie = Info.objects.raw('SELECT calorie FROM product_info WHERE unit = %s AND item = %s',[unit, item])
    print calorie
    