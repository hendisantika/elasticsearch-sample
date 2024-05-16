from elasticsearch import Elasticsearch


def get_client():
    return Elasticsearch(
        ['localhost'],
        scheme="http",
        port=9200,
    )
