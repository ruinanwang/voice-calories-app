from dbAccess import Calorie

def retrieveUnitItemFromText(text):
    text = processText(text)
    words = text.split()

    totalCalorie = getIntFromString(words[0]) * Calorie.getCalorieByUnitItem(words[1], words[3])[0][0]

    if totalCalorie > 0:
        Calorie.insertCalorieRecord(totalCalorie, words[3])
        return totalCalorie
    else:
        return -1


def processText(text):
    return text

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
    