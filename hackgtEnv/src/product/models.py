from django.db import models

# Create your models here.
class Info(models.model):
    number = models.TextField()
    unit = models.TextField()
    item = models.TextField()