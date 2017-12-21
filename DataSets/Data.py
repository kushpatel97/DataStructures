import json
import sys
import requests


response = requests.get('http://api.open-notify.org/iss-now.json')
json_data = response.content
json_dict = json.loads(json_data)

lat_long = []
direction = json_dict['iss_position']
for fields in direction:
    lat_long.append(direction[fields])
print(lat_long)