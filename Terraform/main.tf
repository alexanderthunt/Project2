provider "aws" {
  region     = "us-east-1"
  profile = "team-sol"
  # access_key = var.access_key
  # secret_key = var.secret_key
}

module "rds" {
  source = "terraform-aws-modules/rds/aws"

  identifier             = "teamsol"
  allocated_storage      = 20
  storage_type           = "gp2"
  engine                 = "postgres"
  engine_version         = "13.7"
  instance_class         = "db.t3.micro"
  db_name                = "planetarium"
  username               = var.rds_user
  password               = var.rds_password
  vpc_security_group_ids = [var.vpc_security_group_ids]
  port                   = "5432"
  family                 = "postgres13"
  publicly_accessible    = true
  skip_final_snapshot    = true
  create_random_password = false
}

resource "aws_s3_bucket" "terraform_state" {
  # if you get a "wrong region" error there is a good chance it is because of your bucket name
  bucket = "revature-team-sol-bucket" # this bucket name has already been taken, leaving it for now to show error message
  lifecycle {
    prevent_destroy = false # this makes sure terraform does not destroy the bucket
  }
  versioning {
    enabled = true # this makes the bucket keep track of the various objects placed inside
  }
  server_side_encryption_configuration {
    rule {
      apply_server_side_encryption_by_default {
        sse_algorithm = "AES256"
      }
    }
  }
  
}