# Week Plan (wip)
API to distribute and set a food week plan. 

## ToDo
- [ ] The plan contains meals for every weekday. 
- [ ] The meals contain every ingredient and the amount needed.
- [x] A meal can be created
- [ ] An ingredient can be created
- [ ] A meal can be added to a weekday
- [ ] A shopping list can be exported from the week plan

## API
- POST   /meals
- GET    /meals
- DELETE /meals
- POST   /weekplan
- GET    /weekplan
- GET    /shoppinglist

## Data model

### Ingredient 
- id
- name
- store?

### Meal
- id
- name
- description

### ~~Meal definition (meal_ingredient)~~
- meal_id
- ingredient_id
- amount