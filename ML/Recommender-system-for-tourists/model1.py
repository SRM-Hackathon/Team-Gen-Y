import numpy as np # library to handle data in a vectorized manner
import pandas as pd # library for data analsysis
from bs4 import BeautifulSoup
import requests # library to handle requests
import json # library to handle JSON files
from pandas.io.json import json_normalize # tranform JSON file into a pandas dataframe

pd.set_option('display.max_columns', None)
pd.set_option('display.max_rows', None)

import sys


# In[55]:

from flask import Flask

app = Flask(__name__)

@app.route("/", methods=['POST'])
def begin():

    
#df = pd.read_csv('cities.csv',header=None)
    with open('csv.txt') as f:
        for l in f.readlines():
            print(l.strip().split("\t"))


# In[61]:


    dataframe=pd.read_csv("csv.txt",delimiter="\t")
    dataframe.to_csv("cities.csv", encoding='utf-8', index=False)


# In[62]:


    dataframe


# In[73]:


    df1=pd.read_csv("places.txt",delimiter="\t")
    df1.to_csv("places.csv", encoding='utf-8', index=False)


# In[74]:


    df1


# In[75]:


    dataframe.sort_values(by=['rating'],inplace=True)


# In[76]:


    dataframe


# In[85]:

    while len(sys.argv):
        i=len(sys.argv)
        if(i==1):
            df1=df1.sort_values(by=["'"+sys.argv[0]+"'"],inplace=True, ascending=False)
            df1['places'].head(50)
        elif(i==2):
            for row in df1.iterrows():
                df1['avg']=(df1["'"+sys.argv[0]+"'"]+df1["'"+sys.argv[1]+"'"])/i
                df1.sort_values(by=['avg'],inplace=True, ascending=False)
                df1['places'].head(50)
        elif(i==3):
            for row in df1.iterrows():
                df1['avg']=(df1["'"+sys.argv[0]+"'"]+df1["'"+sys.argv[1]+"'"]+df1["'"+sys.argv[2]+"'"])/i
                df1.sort_values(by=['avg'],inplace=True, ascending=False)
                df1['places'].head(50)
        elif(i==4):
            for row in df1.iterrows():
                df1['avg']=(df1["'"+sys.argv[0]+"'"]+df1["'"+sys.argv[1]+"'"]+df1["'"+sys.argv[2]+"'"]+df1["'"+sys.argv[3]+"'"])/i
                df1.sort_values(by=['avg'],inplace=True, ascending=False)
                df1['places'].head(50)
        elif(i==5):
            for row in df1.iterrows():
                df1['avg']=(df1["'"+sys.argv[0]+"'"]+df1["'"+sys.argv[1]+"'"]+df1["'"+sys.argv[2]+"'"]+df1["'"+sys.argv[3]+"'"]+df1["'"+sys.argv[4]+"'"])/i
                df1.sort_values(by=['avg'],inplace=True, ascending=False)
                df1['places'].head(50)
        elif(i==6):
            for row in df1.iterrows():
                df1['avg']=(df1["'"+sys.argv[0]+"'"]+df1["'"+sys.argv[1]+"'"]+df1["'"+sys.argv[2]+"'"]+df1["'"+sys.argv[3]+"'"]+df1["'"+sys.argv[4]+"'"]+df1["'"+sys.argv[5]+"'"])/i
                df1.sort_values(by=['avg'],inplace=True, ascending=False)
                df1['places'].head(50)
        elif(i==7):
            for row in df1.iterrows():
                df1['avg']=(df1["'"+sys.argv[0]+"'"]+df1["'"+sys.argv[1]+"'"]+df1["'"+sys.argv[2]+"'"]+df1["'"+sys.argv[3]+"'"]+df1["'"+sys.argv[4]+"'"]+df1["'"+sys.argv[5]+"'"]+df1["'"+sys.argv[6]+"'"])/i
                df1.sort_values(by=['avg'],inplace=True, ascending=False)
                df1['places'].head(50)