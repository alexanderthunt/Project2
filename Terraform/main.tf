# the name provided in the provider section (see the word in quotation marks) needs to match the name of the required
# provider in our terraform.tf file, where we defined our required_provder
provider "aws" {
  region     = "us-east-1"
  access_key = var.access_key
  secret_key = var.secret_key
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
