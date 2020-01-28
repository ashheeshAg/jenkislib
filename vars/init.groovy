def init() {
    sh  """
                  terraform init -input=false
  """
  }
