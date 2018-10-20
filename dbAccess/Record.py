from product.models import Record
from django.db import connection

def getRecordByTimeId(time, uid):
    c = connection.cursor()
    recordListById = c.execute('SELECT calorie FROM product_record WHERE uid = %d', [uid])
    return recordListById.fetchall()