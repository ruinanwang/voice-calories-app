from rest_framework.views import APIView
from rest_framework.response import Response
from product.models import Info
from rest_framework.decorators import api_view

class fetchCalorie(APIView):
    @api_view(['GET'])
    def hello_world(request):
        return Response({"message": "Hello, world!"})
    # def getCalorieByUnitItem(self, unit, item, request, format=None):

