terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 4.0"
    }
  }

  backend "s3" {
    bucket = "revature-team-sol-bucket"
    profile = "team-sol"
    region = "us-east-1"
    key = "state/terraform.tfstate"
    encrypt = true
  }
}