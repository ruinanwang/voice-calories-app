from django.shortcuts import render

from django.contrib.auth.models import User, Group
from product.models import Info
from rest_framework import viewsets
from product.serializers import UserSerializer, GroupSerializer, ProductSerializer

# Create your views here.
class ProductViewSet(viewsets.ModelViewSet):
    """
    API endpoint that allows groups to be viewed or edited.
    """
    queryset = Info.objects.all()
    serializer_class = ProductSerializer