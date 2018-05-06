#include "stack.h"

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct Stack
{
	int size;
	s_elem *head;
};
/* Beginning of assignment -------------------------------------------------------------------------- */
typedef struct s_elem
{
	// TODO: One element of a stack consists of a name, an integer index and a pointer to the element under this one (predecessor)
	char *name;
	int index;
	s_elem *prev_elem;
}s_elem;

Stack* stack_new()
{
	struct Stack *new_stack = malloc(sizeof(Stack));
	if(new_stack == NULL)
		return NULL;

	new_stack->size = 0;
	new_stack->head = NULL;

	return new_stack;
}

s_elem* s_elem_new(char* name)
{
	s_elem *new_elem = malloc(sizeof(s_elem));
	if(new_elem == NULL)
		return NULL;

	new_elem->name = malloc(1 + strlen(name));
	if(new_elem->name == NULL)
		return NULL;

	strcpy(new_elem->name, name);
	new_elem->index = 0;
	new_elem->prev_elem = NULL;

	return new_elem;
}

void stack_free(Stack *stack)
{
	if(stack == NULL) {
		return;
	} else {
		s_elem *cur_elem = stack->head;
		while(cur_elem != NULL) {
			s_elem *next_elem = cur_elem->prev_elem;
			free(cur_elem->name);
			free(cur_elem);
			cur_elem = next_elem;
		}

		free(stack);
	}
}

char* stack_push(Stack *stack, s_elem* newElem)
{
	if(newElem == NULL) {
		return NULL;
	} else {
	    newElem->prev_elem = stack->head;
	    stack->head = newElem;

	    newElem->index = stack->size;
	    stack->size ++;

		return newElem->name;
	}
}

char* stack_peek(Stack *stack)
{
	return stack->head->name;
}

void stack_pop(Stack *stack, char **name)
{
	if(stack->head == NULL) {
		return_null:
		name = NULL;
		return;
	} else {
		s_elem *cur_elem = stack->head;

		char *nm = malloc(1 + strlen(cur_elem->name));
		if(nm == NULL)
			goto return_null;

		//printf("+++Name: %s \n", cur_elem->name);
		strcpy(nm, cur_elem->name);
		*name = nm;

		stack->head = cur_elem->prev_elem;
		stack->size --;

		free(cur_elem->name);
		free(cur_elem);
	}
}

int stack_size(Stack *stack){
  return stack->size;
}

void stack_print(Stack *stack)
{
 	s_elem *cur_elem = stack->head;
	while(cur_elem != NULL) {
		printf("(%d,%s)\n",cur_elem->index, cur_elem->name);
		cur_elem = cur_elem->prev_elem;
	}
}
/* End of assignment -------------------------------------------------------------------------- */
