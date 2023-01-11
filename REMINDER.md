# Reminder

## update branch after successful merge from branch to main

```bash
git pull origin main
```

## [AWS CLI installation](https://docs.aws.amazon.com/cli/latest/userguide/getting-started-install.htm)

## [kubectl installation](https://kubernetes.io/docs/tasks/tools/install-kubectl-windows/)

## [Helm installation](https://helm.sh/docs/intro/install/)

### Helm repo

[nginx](https://github.com/kubernetes/ingress-nginx/tree/main/charts/ingress-nginx)

```cli
helm repo add ingress-nginx https://kubernetes.github.io/ingress-nginx
```

[loki-stack](https://github.com/grafana/helm-charts/tree/main/charts/loki-stack)

```cli
helm repo add grafana https://grafana.github.io/helm-charts
```

[prometheus-stack](https://github.com/prometheus-community/helm-charts/blob/main/charts/kube-prometheus-stack/values.yaml)

```cli
helm repo add prometheus-community https://prometheus-community.github.io/helm-charts
```

[jenkins](https://github.com/jenkinsci/helm-charts/tree/main/charts/jenkins)

```cli
helm repo add jenkins https://charts.jenkins.io
```

### Installation

nginx

```cli
helm upgrade --install nginx ingress-nginx/ingress-nginx
```

loki-stack

```cli
helm upgrade --install loki grafana/loki-stack
```

prometheus-stack

```cli
helm upgrade --install prometheus prometheus-community/kube-prometheus-stack -f prometheus-grafana-values.yml
```

jenkins

```cli
helm upgrade --install jenkins jenkins/jenkins -f jenkins-values.yml
```

## Files needed

- Manifests

  - deployment
  - clusterip
  - ingress
  - configmap
    - promtail-config

- Values
  - grafana-prometheus
  - jenkins

## Data Source url

- `http://prometheus-kube-prometheus-prometheus.default:9090`
- `http://loki:3100`
