# Elasticsearch & Kibana Basics #

Elasticsearch (ES) is a powerful and efficient NoSQL document store that can also be using as a caching mechanism.
We will cover the basic features necessary to make a full application on top of it.
Kibana is the web interface used to manage Elasticsearch indexes.

## Running Elasticsearch server & Kibana instances

### Option 1. Starting as standalone docker containers

    docker network create elasticnet
    docker run --name es-server --net elasticnet -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:7.13.4
    docker run --name kibana --net elasticnet -p 5601:5601 -e "ELASTICSEARCH_HOSTS=http://es-server:9200" docker.elastic.co/kibana/kibana:7.13.4

### Option 2. Running with docker compose using the provided docker-compose.yml file

    docker-compose up -d

Elasticsearch server will be available at http://localhost:9200 and Kibana at http://localhost:5601

## Overview

There are essentially two ways of interacting with ES:

- Directly invoking the REST services provided by the server
- Using a library that wraps these calls

In this tutorial, we will cover the usage of the REST services with straightforward CURL commands.
Full API documentation is available
at [Elasticsearch website](https://www.elastic.co/guide/en/elasticsearch/reference/current/index.html).

The commands below can be reproduced with any of your favorite HTTP client such as Postman, Insomnia or others.

## Clients

You can find samples of Java or Python clients in the subfolders of this repository.

### Create Document #

curl -XPOST -H 'Content-Type: application/json' -d '{"name":"first"}' localhost:9200/test/_doc
curl -XPOST -H 'Content-Type: application/json' -d '{"name":"second"}' localhost:9200/test/_doc

### List Documents #

curl -H 'Content-Type: application/json' -d '{"query":{"match_all":{}}}' localhost:9200/test/_search

### Get Document by ID #

curl localhost:9200/test/_doc/P0JhqHoBhwK0O_SdbU7r

### Find Document by field #

curl -H 'Content-Type: application/json' -d '{"query":{"bool":{"should":[{"term":{"_id":"P0JhqHoBhwK0O_SdbU7r"}}]}}}'
localhost:9200/test/_search

**Request body:**

    {
        "query": {
            "bool": {
                "should":[
                    {
                        "term": { "_id": "P0JhqHoBhwK0O_SdbU7r" }
                    }
                ]
            }
        }
    }

curl -H 'Content-Type: application/json' -d '{"query":{"bool":{"should":[{"term":{"name":"first"}}]}}}' localhost:
9200/test/_search

**Request body:**

    {
        "query": {
            "bool": {
                "should":[
                    {"term": {"name":"first"}
                ]
            }
        }
    }

### Delete by ID

curl -XDELETE localhost:9200/test/_doc/P0JhqHoBhwK0O_SdbU7r

### Delete by query

curl -H 'Content-Type: application/json' -d '{"query":{"bool":{"should":[{"term":{"name":"leo"}}]}}}' localhost:
9200/test/_delete_by_query

### Search with pagination

See more details
at [ES Scroll API page](https://www.elastic.co/guide/en/elasticsearch/reference/current/paginate-search-results.html)
