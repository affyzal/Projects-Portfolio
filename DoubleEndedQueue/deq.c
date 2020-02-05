/*
	NAME: Afzal Miah
	Matric Number: 170010026
	Module code: AC21008
*/



#include "deq.h"
#include <stdlib.h>
#include <stdio.h>


int initDEQueue(DEQueue **qPtr){
	if (qPtr == NULL)
	{
		return NULL_PARAM;
	}
	if (*qPtr != NULL)
	{
		return BAD_INIT_PARAM;
	}
	(*qPtr) = (DEQueue*)myMalloc(sizeof(DEQueue));
	if ((*qPtr) == NULL){
		return OUT_OF_MEMORY;
	}
	(*qPtr)->head = NULL;
	(*qPtr)->tail = NULL;
	return SUCCESS;
}

int pushTail(DEQueue *qPtr, int data){
	if(qPtr == NULL){
		return NULL_PARAM;
	}
	Node *newNode = (Node*)myMalloc(sizeof(Node));
	if(newNode == NULL){
		return OUT_OF_MEMORY;
	}
	if(qPtr->tail->next != NULL){
		return BAD_DEQ;
	}
	if(qPtr->head == NULL && qPtr->tail == NULL){
		newNode->data = data;
		newNode->next = NULL;
		qPtr->head = newNode;
		qPtr->tail = newNode;
	}
	else{
		newNode->data = data;
		newNode->next = NULL;
		qPtr->tail->next = newNode;
		qPtr->tail = newNode;
		return SUCCESS;
	}
	return 0;
}

int pushHead(DEQueue *qPtr, int data){
	if(qPtr == NULL){
		return NULL_PARAM;
	}
	Node *newNode = (Node*)myMalloc(sizeof(Node));
	if(newNode == NULL){
		return OUT_OF_MEMORY;
	}
	if(qPtr->head == NULL && qPtr->tail == NULL){
		newNode->data = data;
		newNode->next = NULL;
		qPtr->head = newNode;
		qPtr->tail = newNode;
	}
	else{
		newNode->data = data;
		newNode->next = qPtr->head;
		qPtr->head = newNode;
		return SUCCESS;
	}
	return 0;
}

int popHead(DEQueue* qPtr, int* dataPtr){
	if(qPtr == NULL){
		return NULL_PARAM;
	}
	if(dataPtr == NULL){
		return NULL_PARAM;
	}
	if(qPtr->head == NULL){
		return POP_EMPTY_DEQ;
	}
	*dataPtr = qPtr->head->data;
	Node *nodeToRemove = qPtr->head;
	qPtr->head = qPtr->head->next;
	nodeToRemove->next = NULL;
	nodeToRemove->data = 0;
	free(nodeToRemove);
	
	return SUCCESS;
}

int peekHead(DEQueue* qPtr, int* dataPtr){
	if (qPtr == NULL){
		return NULL_PARAM;
	}
	if (dataPtr == NULL){
		return NULL_PARAM;
	}
	if (qPtr->head == NULL){
		return PEEK_EMPTY_DEQ;
	}
	*dataPtr = qPtr->head->data;
	return SUCCESS;
}

int peekTail(DEQueue* qPtr, int* dataPtr){
	if (qPtr == NULL){
		return NULL_PARAM;
	}
	if (dataPtr == NULL){
		return NULL_PARAM;
	}
	if (qPtr->head == NULL){
		return PEEK_EMPTY_DEQ;
	}
	*dataPtr = qPtr->tail->data;
	return SUCCESS;
}

int freeDEQueue(DEQueue *qPtr){
	if (qPtr == NULL){
		return NULL_PARAM;
	}
	while(qPtr->head != NULL){
		Node *currentHead = qPtr->head;
		qPtr->head = qPtr->head->next;
		currentHead->next = NULL;
		currentHead->data = 0;
		free(currentHead);
	}
	free(qPtr);
	return SUCCESS;
}

