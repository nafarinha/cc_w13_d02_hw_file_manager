# Homework: Annotating One-to-Many and Many-to-One Relationships

### Learning Objectives

- Understand the relationships, one to many and many to many
- Be able to use Spring Data REST to create the RESTful routes for a set of resources
- Use insomia to GET, POST, PUT and DELETE records

## Brief

Create a one-to-many Spring application using annotations as you've done before.

Your application should have the following models: `Folders`, `Files` and `Users`. Users should have many folders, and folders should have many files.

Note: you don't need **any** controllers - Spring Data Rest should handle all of these.

### MVP

- Create a system to track files and folders: :ballot_box_with_check:
  - A `File` should have:
    - a name
    - extension (e.g. txt, rb, java, ppt)
    - size
    - folder
  - A `User` should have:
    - name
    - a list of folders
  - A `Folder` should have:
    - a title
    - list of files
    - a user
- Creata a seeding file `DataLoader` component to pre-seed the database. :ballot_box_with_check:
- Test with unit tests and manually inspecting postgres :ballot_box_with_check:
- Enable Spring Data REST to create the RESTful routes to GET, POST, PUT, and DELETE :ballot_box_with_check:



```bash
curl --request GET \
  --url http://localhost:8080/users
```

<details>

<summary>Expand response</summary>



```bash
{
  "_embedded" : {
    "users" : [ {
      "name" : "Travis",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/users/1"
        },
        "user" : {
          "href" : "http://localhost:8080/users/1"
        },
        "folders" : {
          "href" : "http://localhost:8080/users/1/folders"
        }
      }
    }, {
      "name" : "David",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/users/2"
        },
        "user" : {
          "href" : "http://localhost:8080/users/2"
        },
        "folders" : {
          "href" : "http://localhost:8080/users/2/folders"
        }
      }
    } ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/users{?page,size,sort}",
      "templated" : true
    },
    "profile" : {
      "href" : "http://localhost:8080/profile/users"
    }
  },
  "page" : {
    "size" : 20,
    "totalElements" : 2,
    "totalPages" : 1,
    "number" : 0
  }
}%  
```

</details>



```bash
curl --request GET \
  --url http://localhost:8080/folders
```

<details>

<summary>Expand response</summary>



```bash
{
  "_embedded" : {
    "folders" : [ {
      "title" : "Documents",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/folders/1"
        },
        "folder" : {
          "href" : "http://localhost:8080/folders/1"
        },
        "files" : {
          "href" : "http://localhost:8080/folders/1/files"
        },
        "user" : {
          "href" : "http://localhost:8080/folders/1/user"
        }
      }
    }, {
      "title" : "Documents",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/folders/2"
        },
        "folder" : {
          "href" : "http://localhost:8080/folders/2"
        },
        "files" : {
          "href" : "http://localhost:8080/folders/2/files"
        },
        "user" : {
          "href" : "http://localhost:8080/folders/2/user"
        }
      }
    } ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/folders{?page,size,sort}",
      "templated" : true
    },
    "profile" : {
      "href" : "http://localhost:8080/profile/folders"
    }
  },
  "page" : {
    "size" : 20,
    "totalElements" : 2,
    "totalPages" : 1,
    "number" : 0
  }
}% 
```

</details>



```bash
curl --request GET \
  --url http://localhost:8080/files
```

<details>

<summary>Expand response</summary>



```bash
{
  "_embedded" : {
    "files" : [ {
      "name" : "todo",
      "extension" : ".txt",
      "size" : 1.1,
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/files/2"
        },
        "file" : {
          "href" : "http://localhost:8080/files/2"
        },
        "folder" : {
          "href" : "http://localhost:8080/files/2/folder"
        }
      }
    }, {
      "name" : "homework",
      "extension" : ".pdf",
      "size" : 5.1,
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/files/3"
        },
        "file" : {
          "href" : "http://localhost:8080/files/3"
        },
        "folder" : {
          "href" : "http://localhost:8080/files/3/folder"
        }
      }
    }, {
      "name" : "cover_letter",
      "extension" : ".docx",
      "size" : 7.2,
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/files/4"
        },
        "file" : {
          "href" : "http://localhost:8080/files/4"
        },
        "folder" : {
          "href" : "http://localhost:8080/files/4/folder"
        }
      }
    }, {
      "name" : "cv",
      "extension" : ".docx",
      "size" : 18.7,
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/files/5"
        },
        "file" : {
          "href" : "http://localhost:8080/files/5"
        },
        "folder" : {
          "href" : "http://localhost:8080/files/5/folder"
        }
      }
    }, {
      "name" : "report_FINAL",
      "extension" : ".docx",
      "size" : 120.0,
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/files/1"
        },
        "file" : {
          "href" : "http://localhost:8080/files/1"
        },
        "folder" : {
          "href" : "http://localhost:8080/files/1/folder"
        }
      }
    } ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/files{?page,size,sort}",
      "templated" : true
    },
    "profile" : {
      "href" : "http://localhost:8080/profile/files"
    }
  },
  "page" : {
    "size" : 20,
    "totalElements" : 5,
    "totalPages" : 1,
    "number" : 0
  }
}%  
```

</details>



```bash
curl --request POST \
  --url http://localhost:8080/users \
  --header 'content-type: application/json' \
  --data '{
	"name" : "Jack"
}'
```

<details>

  


<summary>Expand response</summary>



```bash
{
  "name" : "Jack",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/users/4"
    },
    "user" : {
      "href" : "http://localhost:8080/users/4"
    },
    "folders" : {
      "href" : "http://localhost:8080/users/4/folders"
    }
  }
}%     
```

</details>



```bash
curl --request POST \
  --url http://localhost:8080/folders \
  --header 'content-type: application/json' \
  --data '{
	"title" : "Applications",
	"user" : "http://localhost:8080/users/1"
}'
```

<details>
  

<summary>Expand response</summary>



```bash
{
  "title" : "Applications",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/folders/4"
    },
    "folder" : {
      "href" : "http://localhost:8080/folders/4"
    },
    "files" : {
      "href" : "http://localhost:8080/folders/4/files"
    },
    "user" : {
      "href" : "http://localhost:8080/folders/4/user"
    }
  }
}%  
```

</details>



```bash
curl --request POST \
  --url http://localhost:8080/files \
  --header 'content-type: application/json' \
  --data '{
	"name" : "The Matrix",
	"extension" : ".mp4",
	"size" : "650",
	"folder" : "http://localhost:8080/folder/1"
}'
```

<details>
  

  <summary>Expand response</summary>



```bash
{
  "name" : "The Matrix",
  "extension" : ".mp4",
  "size" : 650.0,
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/files/7"
    },
    "file" : {
      "href" : "http://localhost:8080/files/7"
    },
    "folder" : {
      "href" : "http://localhost:8080/files/7/folder"
    }
  }
}%  
```

</details>



```bash
curl --request PUT \
  --url http://localhost:8080/users/3 \
  --header 'content-type: application/json' \
  --data '{
	"name" : "Jack Smith"
}'
```

<details>
  <summary>Expand response</summary>



```bash
{
  "name" : "Jack Smith",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/users/5"
    },
    "user" : {
      "href" : "http://localhost:8080/users/5"
    },
    "folders" : {
      "href" : "http://localhost:8080/users/5/folders"
    }
  }
}%  
```

</details>



```bash
curl --request PUT \
  --url http://localhost:8080/folders/3 \
  --header 'content-type: application/json' \
  --data '{
	"title" : "My Applications",
	"user" : "http://localhost:8080/users/1"
}'
```

<details>

  <summary>Expand response</summary>



```bash
{
  "title" : "My Applications",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/folders/5"
    },
    "folder" : {
      "href" : "http://localhost:8080/folders/5"
    },
    "files" : {
      "href" : "http://localhost:8080/folders/5/files"
    },
    "user" : {
      "href" : "http://localhost:8080/folders/5/user"
    }
  }
}% 
```

</details>



```bash
curl --request PUT \
  --url http://localhost:8080/files/1 \
  --header 'content-type: application/json' \
  --data '{
	"name" :	"report_FINAL",
	"extension" :	".docx",
	"size" :	120,
	"folder" : "http://localhost:8080/folder/2"
}'
```

<details>



<summary>Expand response</summary>



```bash
{
  "name" : "report_FINAL",
  "extension" : ".docx",
  "size" : 120.0,
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/files/1"
    },
    "file" : {
      "href" : "http://localhost:8080/files/1"
    },
    "folder" : {
      "href" : "http://localhost:8080/files/1/folder"
    }
  }
}%  
```

</details>



```bash
curl --request DELETE \
  --url http://localhost:8080/users/3
```

```bash
curl --request DELETE \
  --url http://localhost:8080/folders/3
```

```bash
curl --request DELETE \
  --url http://localhost:8080/files/6
```



## Planning

Draw a diagram detail the relationships between models.
