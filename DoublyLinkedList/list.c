/*
	NAME: Afzal Miah
	MATRICULATION NUMBER: 170010026
	MODULE CODE: AC21008
*/

#include "list.h"
#include <stdlib.h>
#include <stdio.h>

int listInit(List **listPtr){
	if (listPtr == NULL){
		return NULL_PARAM;
	}
	if (*listPtr != NULL){
		return BAD_INIT_PARAM;
	}
	(*listPtr) = (List*)myMalloc(sizeof(List));
	if ((*listPtr) == NULL){
		return OUT_OF_MEMORY;
	}
	(*listPtr)->head = NULL;
	(*listPtr)->tail = NULL;
	(*listPtr)->curr = NULL;
	return SUCCESS;
}

int insertBeforeCurr(List* listPtr, int data){
	if(listPtr == NULL){
		return NULL_PARAM;
	}
	ListNode *newNode = (ListNode*)myMalloc(sizeof(ListNode));
	if(newNode == NULL){
		return OUT_OF_MEMORY;
	}

	if(listPtr->head == NULL && listPtr->tail == NULL){
		newNode->data = data;
		newNode->next = NULL;
		newNode->prev = NULL;
		listPtr->head = newNode;
		listPtr->curr = newNode;
		listPtr->tail = newNode;
	}
	else{
		if(listPtr->curr == listPtr->head && listPtr->curr->prev == NULL){
			newNode->data = data;
			newNode->next = listPtr->curr;
			listPtr->curr->prev = newNode;
			listPtr->head = newNode;
			newNode->prev = NULL;
		}
		if(listPtr->head != listPtr->curr && listPtr->curr->prev != NULL){
			newNode->data = data;
			newNode->next = listPtr->curr;
			newNode->prev = listPtr->curr->prev;
			listPtr->curr->prev->next = newNode;
			listPtr->curr->prev = newNode;
		}

	}
	return SUCCESS;

}

int insertAfterCurr(List* listPtr, int data){
	if(listPtr == NULL){
		return NULL_PARAM;
	}
	ListNode *newNode = (ListNode*)myMalloc(sizeof(ListNode));
	if(newNode == NULL){
		return OUT_OF_MEMORY;
	}
	if(listPtr->head == NULL && listPtr->tail == NULL){
		newNode->data = data;
		newNode->next = NULL;
		newNode->prev = NULL;
		listPtr->head = newNode;
		listPtr->curr = newNode;
		listPtr->tail = newNode;
	}
	else{
		if(listPtr->curr == listPtr->tail && listPtr->curr->next == NULL){
			newNode->data = data;
			newNode->prev = listPtr->curr;
			listPtr->curr->next = newNode;
			listPtr->tail = newNode;
			newNode->next = NULL;
		}
		if(listPtr->curr->next != NULL){
			newNode->data = data;
			newNode->prev = listPtr->curr;
			newNode->next = listPtr->curr->next;
			listPtr->curr->next->prev = newNode;
			listPtr->curr->next = newNode;
		}
	}
	return SUCCESS;
}

int currToPrev(List* listPtr){
	if(listPtr == NULL){
		return NULL_PARAM;
	}

	if(listPtr->head == NULL && listPtr->tail == NULL){
		return MOVE_IN_EMPTY_LIST;
	}
	if(listPtr->curr == listPtr->head && listPtr->curr->prev == NULL){
		return MOVE_PREV_AT_HEAD;
	}

	else{
		listPtr->curr = listPtr->curr->prev;
	}
	return SUCCESS;
}

int currToNext(List* listPtr){
	if(listPtr == NULL){
		return NULL_PARAM;
	}
	if(listPtr->head == NULL && listPtr->tail == NULL){
		return MOVE_IN_EMPTY_LIST;
	}
	if(listPtr->curr == listPtr->tail && listPtr->curr->next == NULL){
		return MOVE_NEXT_AT_TAIL;
	}
	else{
		listPtr->curr = listPtr->curr->next;
	}
	return SUCCESS;
}

int getDataAtCurr(List* listPtr, int *data){
	if(listPtr == NULL){
		return NULL_PARAM;
	}
	if(data == NULL){
		return NULL_PARAM;
	}
	if(listPtr->head == NULL){
		return GET_FROM_EMPTY_LIST;
	}
	else{
		*data = listPtr->curr->data;
	}
	return SUCCESS;
}

int removeAtCurr(List* listPtr, int *data, int moveForward){
	if(listPtr == NULL){
		return NULL_PARAM;
	}
	if(data == NULL){
		return NULL_PARAM;
	}

	if(listPtr->head == NULL && listPtr->tail == NULL){
		return REMOVE_FROM_EMPTY_LIST;
	}


	ListNode *nodeToRemove = (ListNode*)myMalloc(sizeof(ListNode));

	//deleting from head of list when only one item in list
	if(listPtr->curr == listPtr->head && listPtr->curr == listPtr->tail){
		nodeToRemove = listPtr->curr;
		*data = listPtr->curr->data;
		listPtr->tail = NULL;
		listPtr->head = NULL;
		listPtr->curr = NULL;

		free(nodeToRemove);
	}


	//deleting from head when list is more than 1
	if(listPtr->curr == listPtr->head && listPtr->head->next != NULL ){
		nodeToRemove = listPtr->curr;
		*data = listPtr->curr->data;
		listPtr->head = nodeToRemove->next;
		listPtr->head->prev = NULL;
		listPtr->curr = listPtr->head; //if at head cant move back,move forward to new head

		free(nodeToRemove);
	}



	//deleting from tail when list is more than 1
	if(listPtr->curr == listPtr->tail && listPtr->tail->prev != NULL){
		nodeToRemove = listPtr->curr;
		*data = listPtr->curr->data;
		listPtr->tail = nodeToRemove->prev;
		listPtr->tail->next = NULL;
		listPtr->curr = listPtr->tail; //if at tail cant move forward, move back to new tail

		free(nodeToRemove);
	}

	//deleting when not at head or tail(in the middle)
	if(listPtr->curr != listPtr->head && listPtr->curr != listPtr->tail){
		nodeToRemove = listPtr->curr;
		*data = listPtr->curr->data;
		nodeToRemove->prev->next = nodeToRemove->next;
		nodeToRemove->next->prev = nodeToRemove->prev;
		if(moveForward !=0){
			listPtr->curr = nodeToRemove->next; //move forward
		}
		else{
			listPtr->curr = nodeToRemove->prev; //move back
		}
		free(nodeToRemove);
	}

	return SUCCESS;
}

int listFree(List* listPtr){
	if(listPtr == NULL){
		return NULL_PARAM;
	}
	
	ListNode *nodeToRemove = (ListNode*)myMalloc(sizeof(ListNode));

	while(listPtr->head != NULL){
		listPtr->curr = listPtr->head;
		nodeToRemove = listPtr->curr;
		listPtr->head = nodeToRemove->next;
		listPtr->head->prev = NULL;
		listPtr->curr = listPtr->head;
		nodeToRemove->next = NULL;
		nodeToRemove->data = 0;
		free(nodeToRemove);
	}
	free(listPtr);
	return SUCCESS;
}

