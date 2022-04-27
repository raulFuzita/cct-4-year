import os
from dotenv import load_dotenv
from flask import render_template

load_dotenv()

class HomeController:
    def index(self):
        return render_template('index.html', title=os.getenv("APP_NAME"))