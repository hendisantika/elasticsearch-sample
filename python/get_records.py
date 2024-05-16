import es_client as cli

es = cli.get_client()

res = es.search(index="contacts", body={"query": {"match_all": {}}})

print("Found record(s): %d" % res['hits']['total']['value'])

for hit in res['hits']['hits']:
    row = hit["_source"]
    print("[%s] %s (%s)" % (row['timestamp'], row['name'], row['age']))
