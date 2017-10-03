
.data
P: .asciiz "Enter number to search: "
A: .word 5, 10, 12, 14, 1, 2, 3, 4, 6, 7, 8, 9, 13, 14, 21, 77, 18, 20, 25, 26

.text
.globl main

main:
	li $v0, 4
	la $a0, P
	syscall
	
	li $v0, 5
	syscall
	
	move $t0, $v0
	li $t1, 0
	li $s0, 20
	la $s1, A
LOOP: 	slt $t5, $t1, $s0
		beq $t5, $zero, FAIL
		sll $t2, $t1, 2
		add $t3, $s1, $t2
		lw $t4, 0($t3)
		beq $t4, $t0, DONE
		addi $t1, $t1, 1
		j LOOP
FAIL:
		li $t1, -1
DONE:		
		
		li $v0, 1
		move $a0, $t1
		syscall
		
		li $v0,10
		syscall