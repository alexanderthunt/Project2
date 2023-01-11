# TO-DOs

## Project 2 - Planetarium in Kubernetes

- added functionality (web app)
  - if any

# Files Needed

- Manifests

  - [ ] deployment.yml - Alexander
  - [ ] clusterip.yml - Tristan
  - [ ] ingress.yml - Tristan
  - [ ] Service Monitor - Sabrina
  - [ ] configmap - Alexander
    - [ ] promtail-config.yml

- Values
  - [ ] grafana-prometheus.yml - Sabrina
  - [ ] jenkins.yml - Tristan

# Installation

- Planetarium

```bash
kubectl apply -f k8s/manifest
```

- ingress-nginx

```bash
helm repo add ingress-nginx https://kubernetes.github.io/ingress-nginx
helm upgrade --install nginx ingress-nginx/ingress-nginx
```

- loki-stack

```bash
helm repo add grafana https://grafana.github.io/helm-charts
helm upgrade --install loki grafana/loki-stack
```

- prometheus-stack

```bash
helm repo add prometheus-community https://prometheus-community.github.io/helm-charts
helm upgrade --install prometheus prometheus-community/kube-prometheus-stack -f k8s/values/prometheus-grafana-values.yml
```

- jenkins

```bash
helm repo add jenkins https://charts.jenkins.io
helm upgrade --install jenkins jenkins/jenkins -f k8s/values/jenkins-values.yml
```

# Data Source url

- `http://prometheus-kube-prometheus-prometheus.default:9090`
- `http://loki:3100`
