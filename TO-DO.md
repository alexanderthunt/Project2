# TO-DOs

## Project 2 - Planetarium in Kubernetes

- added functionality (web app)
  - if any

# Files Needed

- Manifests

  - [x] deployment.yml - Alexander
  - [x] clusterip.yml - Tristan
  - [x] ingress.yml - Tristan
  - [x] Service Monitor - Sabrina
  - [x] configmap
    - [x] promtail-config.yml - Alexander

- Values

  - [x] grafana-prometheus.yml - Sabrina
  - [x] jenkins.yml - Tristan

- [x] Jenkinsfile - Alexander
- [x] Terraform
  - [x] main.tf - Sabrina
  - [x] terraform.tf - Alexander
  - [x] variables.tf - Tristan

# Installation

- Planetarium

```bash
kubectl apply -f k8s/manifest
```

- [ingress-nginx](https://github.com/kubernetes/ingress-nginx/tree/main/charts/ingress-nginx)

```bash
helm repo add ingress-nginx
helm upgrade --install nginx ingress-nginx/ingress-nginx
```

- [loki-stack](https://github.com/grafana/helm-charts/tree/main/charts/loki-stack)

```bash
helm repo add grafana https://grafana.github.io/helm-charts
helm upgrade --install loki grafana/loki-stack
```

- [prometheus-stack](https://github.com/prometheus-community/helm-charts/tree/main/charts/kube-prometheus-stack)

```bash
helm repo add prometheus-community https://prometheus-community.github.io/helm-charts
helm upgrade --install prometheus prometheus-community/kube-prometheus-stack -f k8s/values/prometheus-grafana-values.yml
```

- Alerts and Rules

```bash
https://promtools.dev/alerts/errors
```

- [jenkins](https://github.com/jenkinsci/helm-charts/tree/main/charts/jenkins)

```bash
helm repo add jenkins https://charts.jenkins.io
helm upgrade --install jenkins jenkins/jenkins -f k8s/values/jenkins-values.yml
```

- jenkins password

  ```bash
  kubectl get secret jenkins -o jsonpath="{.data.jenkins-admin-password}" | base64 --decode ; echo
  ```

# Data Source url

```bash
http://prometheus-kube-prometheus-prometheus.default:9090
http://loki:3100
```
