from django.shortcuts import render

from django.contrib.auth.models import User, Group
from product.models import Info
from rest_framework import viewsets
from product.serializers import UserSerializer, GroupSerializer, ProductSerializer
from rest_framework.response import Response
from dbAccess import Calorie
from rest_framework.decorators import api_view
from service import text

import json

# Create your views here.
class ProductViewSet(viewsets.ModelViewSet):
    """
    API endpoint that allows groups to be viewed or edited.
    """
    queryset = Info.objects.all()
    serializer_class = ProductSerializer

from rest_framework.decorators import api_view

@api_view(['POST'])
def getCalories(request):
    data = text.retrieveUnitItemFromText(request.data)
    return Response({"calorie":data})

@api_view(['GET', 'POST'])
def getRecordList(request):
    print(retrieveRecordListByTimeID(time, id))
    return Response(123)