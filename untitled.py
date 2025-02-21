import time
import threading

# Define the sender and receiver's window size
window_size = 4
buffer_size = 10

# Shared buffer of frames to be sent
sender_window = []
sender_buffer = list(range(buffer_size))  # Frames to be sent

# Receiver's side (ACKs)
receiver_window = []

# Event to simulate communication between sender and receiver
ack_event = threading.Event()

def sender():
    global sender_window, sender_buffer
    print("Sender: Starting Transmission\n")
    
    # Initialize the window with the first 'window_size' frames
    while sender_buffer:
        if len(sender_window) < window_size and sender_buffer:
            frame = sender_buffer.pop(0)
            sender_window.append(frame)
            print(f"Sender: Sending frame {frame}")
        
        # Simulate transmission and wait for ACK
        ack_event.wait()  # Block until receiver acknowledges
        ack_event.clear()  # Reset the event

        # Slide the window by removing the first element from the sender's window
        if sender_window:
            sent_frame = sender_window.pop(0)
            print(f"Sender: Acknowledgement received for frame {sent_frame}")
        
        time.sleep(1)  # Simulate network delay

def receiver():
    global receiver_window
    print("Receiver: Ready to receive frames\n")
    
    while True:
        if sender_window:
            # Simulate receiving a frame
            frame = sender_window[0]
            print(f"Receiver: Received frame {frame}")
            receiver_window.append(frame)
            
            # Simulate acknowledgment (ACK) sending
            print(f"Receiver: Sending ACK for frame {frame}")
            ack_event.set()  # Notify sender that the frame was received
            
            # Simulate network delay
            time.sleep(1)

# Create sender and receiver threads
sender_thread = threading.Thread(target=sender)
receiver_thread = threading.Thread(target=receiver)

# Start the threads
sender_thread.start()
receiver_thread.start()

# Wait for both threads to finish
sender_thread.join()
receiver_thread.join()
