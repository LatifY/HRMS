# HRMS Project Java Spring Boot

## Features
* Roles Api (Get All)
* Positions Api (Get All)

## PostgreSQL Tables ✔️

### Users
| Name     | Type         |
|----------|--------------|
| Id       | Integer      |
| Email    | Varying[] 60 |
| Password | Varying[] 60 |
| Verified | Boolean      |

### Personels
| Name      | Type         |
|-----------|--------------|
| UserId    | Integer      |
| RoleId    | Integer      |
| FirstName | Varying[] 30 |
| LastName  | Varying[] 30 |

### Employees
| Name        | Type         |
|-------------|--------------|
| UserId      | Integer      |
| PositionId  | Integer      |
| FirstName   | Varying[] 30 |
| LastName    | Varying[] 30 |
| TCNo        | Varying[] 11 |
| DateOfBirthYear | Integer         |

### Employers
| Name             | Type         |
|------------------|--------------|
| UserId           | Integer      |
| CompanyName      | Varying[] 60 |
| Website          | Varying[] 10 |
| VerifiedBySystem | Boolean      |

### Roles
| Name     | Type         |
|----------|--------------|
| Id       | Integer      |
| RoleName | Varying[] 60 |

### Positions
| Name         | Type         |
|--------------|--------------|
| Id           | Integer      |
| PositionName | Varying[] 60 |
