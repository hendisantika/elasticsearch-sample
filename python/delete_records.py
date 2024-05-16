import es_client as cli

es = cli.get_client()

# This statement will delete all documents in the contacts index
res = es.delete_by_query(index="contacts", body={"query": {"match_all": {}}})

# This statement will delete only documents with the given name
res = es.delete_by_query(index="contacts",
                         body={"query": {"bool": {"should": [{"term": {"name.keyword": "John Doe"}}]}}})
