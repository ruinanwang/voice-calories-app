# voice-calories-app

### Django Environment Setup

#### Dependencies needed

Django<br/>
`pip install django`<br/>

Django Restful API Fraimwork<br/>
`pip install djangorestframework`<br/>
`pip install markdown       # Markdown support for the browsable API`<br/>
`pip install django-filter  # Filtering support`<br/>

#### Run the server

Use the environment:<br/>
`cd hackgtEnv/`<br/>
`source bin/activate`<br/>

Serve:
`python manage.py runserver`<br/>

Run the database: <br/>
`python manage.py migrate`

Make new component:<br/>
`Python manage.py startapp product`<br/>
`Python manage.py makemigrations`<br/>
`Python manage.py migrate`<br/>



