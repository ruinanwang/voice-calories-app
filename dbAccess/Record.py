from product.models import Record
from django.db import connection

def getRecordByTimeId(time, uid):
    c = connection.cursor()
    recordListById = c.execute("SELECT item, cal FROM product_record WHERE uid = %s AND time == date('now')", [uid])
    # print (recordListById.fetchall())
    return recordListById.fetchall()