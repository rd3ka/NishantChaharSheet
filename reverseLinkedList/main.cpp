#include <iostream>
using namespace std;

struct Node {
  struct Node* next;
  int data;

  Node(int data) {
    this->data = data;
    this->next = nullptr;
  }
};


static constexpr void display_ll(struct Node* head) {
  for(struct Node* iterator = head; iterator != nullptr; iterator = iterator->next)
    printf("%d ", iterator->data);
  printf("\n");
}

static void reverse_ll(struct Node* &head) {
  struct Node *previous_ptr = nullptr,
              *current_ptr = nullptr,
              *next_ptr = head;
  
  while(next_ptr) {
    previous_ptr = current_ptr;
    current_ptr = next_ptr;
    next_ptr = next_ptr->next;

    current_ptr->next = previous_ptr;
  }
  head->next = current_ptr;
}

int main(int argc, char** argv) {
  struct Node *head = new struct Node(0);
  head->next = new struct Node(1);
  head->next->next = new struct Node(2);
  head->next->next->next = new struct Node(3);
  head->next->next->next->next = new struct Node(4);
  head->next->next->next->next->next = new struct Node(5); 
  display_ll(head);
  reverse_ll(head);
  display_ll(head);
  return 0;
}
