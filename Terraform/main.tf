# the name provided in the provider section (see the word in quotation marks) needs to match the name of the required
# provider in our terraform.tf file, where we defined our required_provder
provider "aws" {
  region     = "us-east-1"
  profile = "terraform"

  # both keys should be provided by an IAM role created in aws
}

resource "aws_s3_bucket" "terraform_state" {
  # if you get a "wrong region" error there is a good chance it is because of your bucket name
  bucket = "revature-team-sol-terraform-state-bucket" # this bucket name has already been taken, leaving it for now to show error message
  lifecycle {
    prevent_destroy = true # this makes sure terraform does not destroy the bucket
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