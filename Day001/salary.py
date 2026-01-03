import random
import matplotlib.pyplot as plt

# Constants
MIN_SALARY = 1      # 1 LPA
MAX_SALARY = 100    # 1 CR = 100 LPA
NUM_COMPANIES = 10
THRESHOLD = 40      # We want minimum to be >= 40 LPA
SIMULATIONS = 100000

# Counter for favorable outcomes
count = 0
min_salaries = []  # Store all minimum salaries for visualization

# Run simulation 1,00,000 times
for i in range(SIMULATIONS):
    # Generate 10 random salaries between 1 LPA and 1 CR
    salaries = []
    for j in range(NUM_COMPANIES):
        salary = random.randint(MIN_SALARY, MAX_SALARY)
        salaries.append(salary)
    
    # Check if minimum salary is >= 40 LPA
    minimum = min(salaries)
    min_salaries.append(minimum)
    
    if minimum >= THRESHOLD:
        count += 1

# Calculate probability
probability = (count / SIMULATIONS) * 100

# Print results
print(f"Total Simulations: {SIMULATIONS}")
print(f"Favorable Outcomes (min >= 40 LPA): {count}")
print(f"Probability: {probability:.4f}%")

# Visualization
fig, (ax1, ax2) = plt.subplots(1, 2, figsize=(14, 5))

# 1. Histogram of minimum salaries
ax1.hist(min_salaries, bins=30, color='steelblue', edgecolor='black')
ax1.axvline(x=THRESHOLD, color='red', linestyle='--', linewidth=2, label=f'Threshold = {THRESHOLD} LPA')
ax1.set_xlabel('Minimum Salary (LPA)')
ax1.set_ylabel('Frequency')
ax1.set_title('Distribution of Minimum Salaries')
ax1.legend()

# 2. Pie chart for favorable vs unfavorable
labels = ['Min >= 40 LPA', 'Min < 40 LPA']
sizes = [count, SIMULATIONS - count]
colors = ['green', 'red']
ax2.pie(sizes, labels=labels, colors=colors, autopct='%1.2f%%', startangle=90)
ax2.set_title('Probability Distribution')

plt.tight_layout()
plt.savefig('salary_visualization.png', dpi=150)
plt.show()

print("\nVisualization saved as 'salary_visualization.png'")
