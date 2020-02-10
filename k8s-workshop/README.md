# **Helm basic chart** #
Contains necessary templates for most application cases to start running on k8s cluster.

## Disclaimer: ##
Using this isn't enough for production environment. Reason behind is because we can't standardize every 
k8s resource, we have to approach every application individually and have application requirement in mind.
We advise you to read the godfather documentation 
(you can find it pinned in our channel) and learn more about autoscaling/monitoring/alerting etc.

## Usage: 
```
1. clone repository 
2. copy files from repository into `project/$chartName/` 
3. run ./replace-name.sh $chartName
4. edit values.yaml variables
```

## Templates: ##

- Deployment
- Service 
- Certificate
- DNSEndpoint
- Secret ( docker registry )
- ServiceMonitor

> **Godfather team strongly support standardization and making your job easier, so you can expect updates and new templates**
