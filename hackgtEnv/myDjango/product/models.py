from django.db import models

# Create your models here.
class Info(models.Model): #get features form default jango model class
    number = models.IntegerField() #connected to db
    unit = models.CharField(max_length = 200)
    item = models.CharField(max_length = 200)

# class product_info(models.Model):
#     number = models.IntegerField()
#     unit = models.TextField()
#     item = models.TextField()
#
#     def __str__(self):
#         return self.item