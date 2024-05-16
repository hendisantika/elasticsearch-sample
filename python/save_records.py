from datetime import datetime

import es_client as cli

es = cli.get_client()

doc = {
    'name': 'John Doe',
    'age': 35,
    'timestamp': datetime.now()
}

result = es.index(index="contacts", body=doc)

print('Saved document with ID: %s\n' % result['_id'])

print('Raw response: %s' % result)
