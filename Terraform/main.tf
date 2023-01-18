# the name provided in the provider section (see the word in quotation marks) needs to match the name of the required
# provider in our terraform.tf file, where we defined our required_provder
provider "aws" {
  region     = "us-east-1"
  # profile = "terraform"
  access_key = var.access_key
  secret_key = var.secret_key
  # both keys should be provided by an IAM role created in aws
}

# resource "aws_s3_bucket" "terraform_state" {
#   # if you get a "wrong region" error there is a good chance it is because of your bucket name
#   bucket = "revature-team-sol-terraform-state-bucket" # this bucket name has already been taken, leaving it for now to show error message
#   lifecycle {
#     prevent_destroy = true # this makes sure terraform does not destroy the bucket
#   }
#   versioning {
#     enabled = true # this makes the bucket keep track of the various objects placed inside
#   }
#   server_side_encryption_configuration {
#     rule {
#       apply_server_side_encryption_by_default {
#         sse_algorithm = "AES256"
#       }
#     }
#   }
# }

module "db" {
  source  = "terraform-aws-modules/rds/aws"

  identifier = "teamsol"

  engine            = "postgres"
  engine_version    = "13.7"
  instance_class    = "db.t3.micro"
  allocated_storage = 10
  max_allocated_storage = 20

  db_name  = "teamsol"
  username = "terraform"
  port     = "5432"

  iam_database_authentication_enabled = true

  vpc_security_group_ids = ["sg-02094add46cdfe497"]

  # maintenance_window = "Mon:00:00-Mon:03:00"
  # backup_window      = "03:00-06:00"

  # Enhanced Monitoring - see example for details on how to create the role
  # by yourself, in case you don't want to create it automatically
  # monitoring_interval = "30"
  # monitoring_role_name = "MyRDSMonitoringRole"
  # create_monitoring_role = true

  tags = {
    Owner       = "user"
    Environment = "dev"
  }

  # DB subnet group
  # create_db_subnet_group = true
  # subnet_ids             = ["subnet-12345678", "subnet-87654321"]

  # DB parameter group
  family = "postgres13"

  # DB option group
  major_engine_version = "13.7"

  # Database Deletion Protection
  deletion_protection = false

}