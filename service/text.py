from dbAccess import Calorie

def retrieveUnitItemFromText(text):
    text = processText(text)
    words = text.split()
    return Calorie.getCalorieByUnitItem(words[1], words[3])

def processText(text):
    return text