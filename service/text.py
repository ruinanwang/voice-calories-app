from dbAccess import Calorie

def retrieveUnitItemFromText(text):
    text = processText(text)
    words = text.split()

    num = None
    if (len(words) >= 1):
        num = getIntFromString(words[0])
    else:
        return -1

    unit = None
    if (len(words) >= 2):
        unit = getUnit(words[1])
    else:
        return -1

    item = None
    if (len(words) >= 4):
        item = words[3]
    else:
        return -1

    totalCalorie = num * Calorie.getCalorieByUnitItem(unit, item)[0][0]

    if totalCalorie > 0:
        Calorie.insertCalorieRecord(totalCalorie, item)
        return totalCalorie
    else:
        return -1


def processText(text):
    return text

def getUnit(unitString):
    if unitString == "cup" or unitString == "cups":
        return "cup"
    elif unitString == "bowl" or unitString == "bowls":
        return "bowl"

def getIntFromString(numberString):
    if numberString == 'one':
        return 1
    elif numberString == 'two':
        return 2
    elif numberString == 'three':
        return 3
    elif numberString == 'four':
        return 4
    elif numberString == 'five':
        return 5
    elif numberString == 'six':
        return 6
    elif numberString == 'seven':
        return 7
    elif numberString == 'eight':
        return 8
    elif numberString == 'nine':
        return 9
    elif numberString == 'ten':
        return 10
    else:
        return 0
    