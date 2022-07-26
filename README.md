# 3pa-register-admin-web

The Third Party Agent Register application is an internal service.
This service is responsible for collecting third party agent details and the issuance of an agent assurance code.

The service integrates with a number of internal systems. 

Requirements
------------
* Java 11
* [Git](https://git-scm.com/downloads)
* [Maven](https://maven.apache.org/download.cgi)
* [3pa-register-api](https://github.com/companieshouse/3pa-register-api)
* Internal Companies House core services
* [CHS Docker](https://github.com/companieshouse/docker-chs-development) for mongoDB, CDN, and co-ordination with 3pa-register-web

## Building and Running Locally

### Docker
- follow the steps in the 3pa-register-api README
- to make changes, development enable `3pa-register-admin-web`

### end-2-end environments
- Concourse pipelines build and deploy this service

## Usage
### Entering third party agencies details
- navigate in the browser to `http://chs.local/third-party-agencies/new`
- enter all details to check that all database fields are populated (there is no validation as yet)
- click Submit to submit form and a 'Submitted' message should be displayed
- you can enter another agent details by refreshing the page
- all the agent details saved in the database can be displayed by navigating the browser to `http://api.chs.local/third-party-agencies/3pas`